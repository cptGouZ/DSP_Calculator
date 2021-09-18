package dsp.calculator.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import dsp.calculator.Datas;
import dsp.calculator.R;
import dsp.calculator.adapters.RecipeResultAdapter;
import dsp.calculator.adapters.RecipeDropdownAdapter;
import dsp.calculator.App;
import dsp.calculator.bo.Recipe;
import dsp.calculator.databinding.MainBinding;
import dsp.calculator.enums.CalculMode;

public class MainActivity extends AppCompatActivity {
    private MainBinding binding;
    private RecipeResultAdapter recipeResultAdapter = new RecipeResultAdapter();
    private RecipeDropdownAdapter spinnerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recipeResultAdapter.setRecipesToDisplay(App.get().getResults());
        binding.recipeListe.setLayoutManager(new LinearLayoutManager(this));
        binding.recipeListe.setAdapter(recipeResultAdapter);

        binding.cmbRecipe.setPrompt("Recipe to make ?");
        setRecipeListe();
        setActions();
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
            case R.id.menuAternatives:
                startActivity(new Intent(this, AlternativeActivity.class));
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    private void setRecipeListe(){
        spinnerArrayAdapter = new RecipeDropdownAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                Datas.get().getAll()
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.recipe_dropdown_item);
        binding.cmbRecipe.setAdapter(spinnerArrayAdapter);
    }

    private void setActions(){
        binding.radNbOfFacility.setOnClickListener(view -> {
            App.get().getSettings().setCalculMode(CalculMode.NB_FACILITY);
        });
        binding.radRatePerMin.setOnClickListener(view -> {
            App.get().getSettings().setCalculMode(CalculMode.RATE_BY_MIN);
        });

        binding.btnSubmit.setOnClickListener((view)->{

            Recipe r = (Recipe)binding.cmbRecipe.getSelectedItem();
            String f = String.valueOf(binding.txtWantedRate.getText());
            if( r != null && !f.isEmpty()) {
                float rate = Float.parseFloat(f);
                App.get().addRecipeToMake(r, rate);
                recipeResultAdapter.setRecipesToDisplay(App.get().getResults());
            }else{
                Toast.makeText(this,"A recipe must be choosen and a wanted rate set", Toast.LENGTH_SHORT).show();
            }
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        });

        binding.btnRemove.setOnClickListener((view)->{
            Recipe r = (Recipe)binding.cmbRecipe.getSelectedItem();
            String f = String.valueOf(binding.txtWantedRate.getText());
            Toast.makeText(this,String.valueOf(binding.txtWantedRate.getText()), Toast.LENGTH_SHORT);

            if( r != null && !f.isEmpty()) {
                float rate = Float.parseFloat(f);
                App.get().removeRecipeToMake(r, rate);
                recipeResultAdapter.setRecipesToDisplay(App.get().getResults());
            }else{
                Toast.makeText(this,"A recipe must be choosen and a wanted rate set", Toast.LENGTH_SHORT).show();
            }
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        });

        binding.btnClear.setOnClickListener((view)->{
            App.get().clearRecipeToMake();
            recipeResultAdapter.setRecipesToDisplay(App.get().getResults());
        });
    }
}