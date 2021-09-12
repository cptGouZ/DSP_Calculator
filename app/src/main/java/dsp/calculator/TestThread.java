package dsp.calculator;

import android.content.Context;
import android.os.Build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dsp.calculator.Datas;
import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.dao.DatabaseManager;
import dsp.calculator.dao.RecipeDao;
import dsp.calculator.enums.FacilityTypes;
import dsp.calculator.enums.RecipeNames;

public class TestThread  extends Thread {
    long minPrime;
    Context context;
    public void setContext(Context context){
        this.context = context;
    }
    public TestThread(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        RecipeDao rdao = DatabaseManager.getInstance(context).recipeDao();
        List<Recipe> recipes = Datas.recipesToLoadInDatabase(rdao);
        for (Recipe r: recipes
             ) {
            rdao.insertRecipeWithConsumptions(r);
        }
        //Recipe r1 = rdao.getRecipeWithConsumptions("copper plate");
        //r1 = r1;
    }
}
