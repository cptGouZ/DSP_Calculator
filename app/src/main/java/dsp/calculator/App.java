package dsp.calculator;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import dsp.calculator.bo.Recipe;
import dsp.calculator.dao.DatabaseManager;
import dsp.calculator.dao.RecipeDao;
import dsp.calculator.enums.RecipeNames;
import lombok.Data;

@Data
public class App extends Application {
    //Singleton
    private static App instance;

    private Context context;
    private Settings settings;
    private List<Recipe> recipes = new ArrayList<>();
    private RecipeDao rdao;

    @Override
    public void onCreate() {
        instance = this;
        context = this.getApplicationContext();
        instance.setSettings( new Settings(context) );
        instance.loadDatabase();
        super.onCreate();
    }

    public static App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance.context;
    }

    private void loadDatabase() {
        rdao = DatabaseManager.getInstance().recipeDao();
        //Load database
        try {
            Thread t = new Thread(() -> {
                DatabaseManager.getInstance().clearAllTables();
                recipes = Datas.recipesToLoadInDatabase(rdao);
                for (Recipe r: recipes ) {
                    rdao.add(r);
                }
            });
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> calcul(String recipeToMake, float wantedRate){
        final List<Recipe>[] retour = new List[]{new ArrayList<>()};
        Thread t = new Thread(()->{
            retour[0] =rdao.getByName(RecipeNames.UNIVERSE_MATRIX);
        });
        return retour[0];
    }
}
