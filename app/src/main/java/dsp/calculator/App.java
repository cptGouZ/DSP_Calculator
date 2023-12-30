package dsp.calculator;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.bo.RecipeCalculation;
import dsp.calculator.enums.CalculMode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class App extends Application {
    //Singleton
    private static App instance;

    private Settings settings;
    private Map<Long, RecipeCalculation> listeOfRecipeToMake = new HashMap<>();
    private Recipe recipeInConsumption;


    @Override
    public void onCreate() {
        instance = this;
        instance.setSettings( new Settings(this.getSharedPreferences(Settings.FILE_SETTINGS, MODE_PRIVATE)) );
        super.onCreate();
    }

    public static App get() {
        return instance;
    }

    public static Context getContext() {
        return instance;
    }

    public void clearRecipeToMake(){
        listeOfRecipeToMake = new HashMap<>();
    }

    public void removeRecipeToMake(Recipe recipe, float rate) {
        long recipeId = recipe.getId();
        if (App.get().getSettings().getCalculMode() == CalculMode.NB_FACILITY){
            rate = recipe.getRateByMinute() * rate;
        }
        if (listeOfRecipeToMake.containsKey(recipeId)){
            float oldConsumptionAsked = listeOfRecipeToMake.get(recipeId).getConsumptionAsked();
            float newConsumptionAsked = oldConsumptionAsked - rate;
            if(newConsumptionAsked<=0) {
                listeOfRecipeToMake.remove(recipeId);
            }else{
                listeOfRecipeToMake.get(recipeId).setConsumptionAsked(newConsumptionAsked);
            }
        }else{
            Toast.makeText(App.getContext(), "Ce n'est pas dans tes demandes", Toast.LENGTH_SHORT).show();
        }
    }

    public void addRecipeToMake(Recipe recipe, float rate){
        long recipeId = recipe.getId();
        if (App.get().getSettings().getCalculMode() == CalculMode.NB_FACILITY){
            rate = recipe.getRateByMinute() * rate;
        }
        if ( !listeOfRecipeToMake.containsKey(recipeId) ) {
            listeOfRecipeToMake.put(recipeId, new RecipeCalculation(recipe, 0));
        }
        float oldConsumptionAsked = listeOfRecipeToMake.get(recipeId).getConsumptionAsked();
        float newConsumptionAsked = oldConsumptionAsked + rate;
        listeOfRecipeToMake.get(recipeId).setConsumptionAsked(newConsumptionAsked);
    }

    public List<RecipeCalculation> getResults(){
        HashMap<Long, RecipeCalculation> mixture = new HashMap<>();
        for (Map.Entry listOfRecipConsumption: listeOfRecipeToMake.entrySet()) {
            RecipeCalculation recipeCalculation = (RecipeCalculation)listOfRecipConsumption.getValue();
            calculLevel(recipeCalculation, mixture);
        }
        return new ArrayList<>(mixture.values());
    }

    private void calculLevel (RecipeCalculation recipeCalculation, HashMap<Long, RecipeCalculation> mixture){
        Long recipeId = recipeCalculation.getRecipe().getId();
        if ( !mixture.containsKey(recipeId) ) {
            mixture.put(recipeId, new RecipeCalculation(recipeCalculation.getRecipe(), 0));
        }
        float oldConsumptionAsked = mixture.get(recipeId).getConsumptionAsked();
        float newConsumptionAsked = oldConsumptionAsked + recipeCalculation.getConsumptionAsked();
        mixture.get(recipeId).setConsumptionAsked(newConsumptionAsked);
        for (Consumption c : recipeCalculation.getRecipe().getConsumptions()) {
            recipeInConsumption = null;
            List<Recipe> resultDao = Datas.get().getByName(c.getConsumedRecipeName());
            if (!resultDao.isEmpty()) {
                recipeInConsumption = resultDao.get(0);
                if(resultDao.size()>1){
                    recipeInConsumption = Datas.get().getById(App.get().getSettings().getAlternative(c.getConsumedRecipeName()));
                }
                float rateOrRecipeInConsumption = recipeCalculation.getConsumptionAsked() * c.getRate();
                RecipeCalculation recursive = new RecipeCalculation(recipeInConsumption, rateOrRecipeInConsumption);
                calculLevel(recursive, mixture);
            }
        }
    }
}
