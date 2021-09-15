package dsp.calculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import dsp.calculator.R;
import dsp.calculator.adapter.RecipeAdapter;
import dsp.calculator.adapter.SpinnerItemAdapter;
import dsp.calculator.App;
import dsp.calculator.databinding.ActivityMainBinding;
import dsp.calculator.enums.RecipeNames;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RecipeAdapter recipeAdapter = new RecipeAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recipeAdapter.setRecipesToDisplay(App.getInstance().getRecipes());
        binding.recipeListe.setLayoutManager(new LinearLayoutManager(this));
        binding.recipeListe.setAdapter(recipeAdapter);
        setBindings();
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
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    private void setBindings(){

        SpinnerItemAdapter spinnerArrayAdapter = new SpinnerItemAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                App.getInstance().getRecipes()
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.recipe_spinner_dropdown_layout);
        binding.cmbRecipe.setAdapter(spinnerArrayAdapter);
        binding.cmbRecipe.setPrompt("Recipe to make ?");
    }

    private void setActions(){
        binding.btnSubmit.setOnClickListener((view)->{
            Log.i("TAG", "setActions: JE NE PASSE PAS" + String.valueOf( App.getInstance().calcul(RecipeNames.ANNIHILATION_CONSTRAINT_SPHERE, 0.2f)) );
            //String recipeToMake = binding.cmbRecipe.getSelectedItem().toString();
            //float wantedRate = Float.parseFloat(String.valueOf(binding.txtWantedRate.getText()));
            Toast.makeText(this, "J'ai appuié", Toast.LENGTH_SHORT).show();
        });
    }
}