package dsp.calculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import dsp.calculator.R;
import dsp.calculator.adapter.RecipeAdapter;
import dsp.calculator.bo.Recipe;
import dsp.calculator.controller.App;

public class MainActivity extends AppCompatActivity {
    Spinner cmbRecipe;
    TextView txtWantedRate;
    ImageButton btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.setInstance(this);
        getViewMembers();
        setActions();


    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Recipe> liste = App.getInstance().calcul(null, 0);
        RecipeAdapter recipeAdapter = new RecipeAdapter(liste);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recipeAdapter);
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

    private void getViewMembers(){
        ArrayAdapter adapter= new ArrayAdapter(
                this, android.R.layout.simple_spinner_item,
                App.getInstance().getRecipesName().toArray()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        txtWantedRate = findViewById(R.id.txtWantedRate);
        btnSubmit = findViewById(R.id.btnSubmit);
        cmbRecipe = findViewById(R.id.cmbRecipe);
        cmbRecipe.setAdapter(adapter);
//        cmbRecipe = findViewById(R.id.cmbRecipe);
//        ArrayAdapter adapter= new ArrayAdapter(
//            this, R.layout.recipe_spinner_layout,
//            App.getInstance().getRecipesName().toArray()
//        );
//        adapter.setDropDownViewResource(R.layout.recipe_spinner_layout);
//        cmbRecipe.setAdapter(adapter);
    }

    private void setActions(){
        btnSubmit.setOnClickListener((view)->{
            Log.i("TAG", "setActions: JE NE PASSE PAS" + String.valueOf( App.getInstance().calcul("tata", 0.2f)) );
            String recipeToMake = cmbRecipe.getSelectedItem().toString();
            float wantedRate = Float.parseFloat(String.valueOf(txtWantedRate.getText()));
            ;

            RecipeAdapter recipeAdapter = new RecipeAdapter(App.getInstance().calcul(recipeToMake, wantedRate));
            RecyclerView recyclerView = findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(recipeAdapter);

        });
    }


}