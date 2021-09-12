package dsp.calculator;

import android.os.Build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.dao.DatabaseManager;
import dsp.calculator.dao.RecipeDao;
import dsp.calculator.enums.FacilityTypes;
import dsp.calculator.enums.RecipeNames;

public class Datas {
    private static RecipeDao recipeDao;
    public static List<Recipe> recipesToLoadInDatabase(RecipeDao recipeDao){
        Datas.recipeDao = recipeDao;
        HashMap<String, Float> consumedRecipes;
        Recipe r;
        List<Recipe> recipesToLoadInDatabase = new ArrayList<>();

        //Electrical Motor
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.IRON_INGOT,2f);
        consumedRecipes.put(RecipeNames.COPPER_INGOT, 1f);
        consumedRecipes.put(RecipeNames.GEAR, 1f);
        r = constructRecipe(RecipeNames.ELECTRIC_MOTOR, FacilityTypes.ASSEMBLER, 30.0f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //Graphène - recette 1
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.ENERGETIC_GRAPHITE, 3f);
        consumedRecipes.put(RecipeNames.SULFURIC_ACID, 1f);
        r = constructRecipe(RecipeNames.GRAPHENE, FacilityTypes.CHEMICAL_PLANT, 40.0f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        //Graphène - recette 2
        consumedRecipes = new HashMap<>();
        consumedRecipes.put(RecipeNames.FIRE_ICE, 2f);
        r = constructRecipe(RecipeNames.GRAPHENE, FacilityTypes.CHEMICAL_PLANT, 60.0f, consumedRecipes);
        recipesToLoadInDatabase.add(r);

        return recipesToLoadInDatabase;
    }

    private static Recipe constructRecipe(String name, String facility, float rateByMinute, HashMap<String, Float> consumptions ){
        List<Consumption> liste = new ArrayList<>();
        for (Map.Entry<String, Float> entry : consumptions.entrySet()) {
            Consumption c = new Consumption();
            c.setConsumedRecipeName(entry.getKey());
            c.setRate(entry.getValue());
            liste.add(c);
        }
        Recipe r = new Recipe(name, facility, rateByMinute, liste);
        return r;
    }
}
