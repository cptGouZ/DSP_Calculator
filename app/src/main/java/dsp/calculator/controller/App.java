package dsp.calculator.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import dsp.calculator.Datas;
import dsp.calculator.bo.Recipe;
import dsp.calculator.dao.DatabaseManager;
import dsp.calculator.dao.RecipeDao;
import lombok.Data;

@Data
public class App {
    private Context context;
    private Settings settings;
    private List<Recipe> recipes = new ArrayList<>();
    private List<String> recipesName = new ArrayList<>();

    //Singleton
    private static App instance;
    private App(){}
    public static App getInstance(){
        return instance;
    }

    public static App setInstance(Context context){
        if(instance == null){
            instance = new App();
            instance.context = context;
            instance.setSettings( new Settings(context) );
            instance.loadDatabase();
        }
        return instance;
    }

    private void loadDatabase(){
        RecipeDao rdao = DatabaseManager.getInstance(context).recipeDao();
        //Load database
        try {
            Thread t = new Thread(() -> {
                DatabaseManager.getInstance(context).clearAllTables();
                recipes = Datas.recipesToLoadInDatabase(rdao);
                for (Recipe r: recipes ) {
                    rdao.add(r);
                    recipesName.add(r.getName());
                }
            });
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
