package dsp.calculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import dsp.calculator.Datas;
import dsp.calculator.R;
import dsp.calculator.adapter.RecipeAdapter;
import dsp.calculator.adapter.SpinnerItemAdapter;
import dsp.calculator.App;
import dsp.calculator.bo.Recipe;
import dsp.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RecipeAdapter recipeAdapter = new RecipeAdapter();
    private SpinnerItemAdapter spinnerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recipeAdapter.setRecipesToDisplay(App.getInstance().getResults());
        binding.recipeListe.setLayoutManager(new LinearLayoutManager(this));
        binding.recipeListe.setAdapter(recipeAdapter);

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
            default :
                return super.onOptionsItemSelected(item);
        }
    }


    private void setRecipeListe(){
        spinnerArrayAdapter = new SpinnerItemAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                Datas.getInstance().getAll()
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.recipe_spinner_dropdown_layout);
        binding.cmbRecipe.setAdapter(spinnerArrayAdapter);
    }

    private void setActions(){
        binding.btnSubmit.setOnClickListener((view)->{
            Recipe r = (Recipe)binding.cmbRecipe.getSelectedItem();
            String f = String.valueOf(binding.txtWantedRate.getText());
            if( r != null && !f.isEmpty()) {
                float rate = Float.parseFloat(f);
                App.getInstance().addRecipeToMake(r, rate);
                recipeAdapter.setRecipesToDisplay(App.getInstance().getResults());
            }else{
                Toast.makeText(this,"A recipe must be choosen and a wanted rate set", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRemove.setOnClickListener((view)->{
            Recipe r = (Recipe)binding.cmbRecipe.getSelectedItem();
            String f = String.valueOf(binding.txtWantedRate.getText());
            Toast.makeText(this,String.valueOf(binding.txtWantedRate.getText()), Toast.LENGTH_SHORT);

            if( r != null && !f.isEmpty()) {
                float rate = Float.parseFloat(f);
                App.getInstance().removeRecipeToMake(r, rate);
                recipeAdapter.setRecipesToDisplay(App.getInstance().getResults());
            }else{
                Toast.makeText(this,"A recipe must be choosen and a wanted rate set", Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnClear.setOnClickListener((view)->{
            App.getInstance().clearRecipeToMake();
            recipeAdapter.setRecipesToDisplay(App.getInstance().getResults());
        });
    }
}