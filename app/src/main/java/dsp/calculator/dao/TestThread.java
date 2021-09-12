package dsp.calculator.dao;

import android.content.Context;

import java.util.HashMap;

import dsp.calculator.bo.Recipe;
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
        ConsumptionDao cdao = DatabaseManager.getInstance(context).consumptionDao();

//        Consumption c1 = new Consumption();
//        c1.setRecipeName("copper plate");
//        c1.setConsumedRecipeName("copper");
//        c1.setRate(10.0f);
//
//        Recipe r1 = new Recipe();
//        r1.setName("copper plate");
//        r1.getConsumptions().add(c1);
//
//        rdao.insertRecipeWithConsumptions(r1);

        //Recipe r1 = rdao.getRecipeWithConsumptions("copper plate");
        //r1 = r1;
    }

    public void insertData(){
        Recipe r1 = new Recipe(RecipeNames.ELECTRICAL_MOTOR, 30.0f, 0f, FacilityTypes.ASSEMBLER);
        HashMap<String, Float> consumption = new HashMap<>();
        consumption.put(RecipeNames.IRON_INGOT,2f);
        consumption.put("gear", 1f);
        consumption.put("magnetic coil", 1f);
    }
}
