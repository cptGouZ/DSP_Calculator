package dsp.calculator;

import static dsp.calculator.bo.Settings.FILE_SETTINGS;
import static dsp.calculator.bo.Settings.KEY_ASSEMBLEUR_RATIO;
import static dsp.calculator.bo.Settings.KEY_SMELTER_RATIO;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.bo.Settings;
import dsp.calculator.dao.DatabaseManager;
import dsp.calculator.dao.RecipeDao;
import dsp.calculator.dao.TestThread;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TestThread p = new TestThread(143);
        p.setContext(this);
        p.start();





        //AppDatabase db =  Room.databaseBuilder(this, AppDatabase.class, "dsp_calculator").allowMainThreadQueries().build();



        //RecipeDao recipeDao = db.recipeDao();

//        Recipe plaque = new Recipe();
//        plaque.setFacilityType(FacilityType.SMELTER);
//        plaque.setName("Alloy plate");
//        plaque.setRateByMinute(60);
//        plaque.setAlternativeRateByMinute(0);
//
//        Recipe consumed = new Recipe();
//        consumed.setFacilityType(FacilityType.ASSEMBLER);
//        consumed.setRateByMinute(200);
//        consumed.setAlternativeRateByMinute(200);
//        consumed.setName("Coal");
//
//        Consumption c1 = new Consumption();
//        c1.setRate(1);
//        c1.setConsumedRecipe(2);
//
//        RecipeWithConsumption r1 = new RecipeWithConsumption();
//        r1.setRecipe(plaque);
//        r1.getConsumedRecipe().add(c1);
//
//        recipeDao.insert(plaque);
//        recipeDao.insert(consumed);
//        RecipeConsumptionCrossRef crf = new RecipeConsumptionCrossRef();
//        crf.setRecipeId(3);
//        crf.setConsumptionId(4);
//        recipeDao.insert(crf);
        //List<RecipeWithConsumption> rwc = recipeDao.getRecipes();
//        Log.i("TAG", "onCreate: " + rwc.get(2).getConsumedRecipe().toString());
//        Log.i("TAG", "onCreate: " + rwc.get(3).getConsumedRecipe().toString());
//        Log.i("TAG", "onCreate: " + rwc.get(4).getConsumedRecipe().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setSettings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuSettings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Paramétrages de l'application
     */
    private void setSettings(){
        Settings.getInstance().setAssemblerRatio(
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).getInt(KEY_ASSEMBLEUR_RATIO, 0)
        );
        Settings.getInstance().setSmelterRatio(
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).getInt(KEY_SMELTER_RATIO, 0)
        );
    }
}