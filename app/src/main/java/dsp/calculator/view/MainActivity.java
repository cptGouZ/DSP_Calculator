package dsp.calculator.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import dsp.calculator.Datas;
import dsp.calculator.R;
import dsp.calculator.adapter.RecipeAdapter;
import dsp.calculator.bo.Recipe;
import dsp.calculator.controller.App;
import dsp.calculator.dao.DatabaseManager;
import dsp.calculator.dao.RecipeDao;

public class MainActivity extends AppCompatActivity {
    Spinner cmbRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.setInstance(this);
        getViewMembers();

    }

    @Override
    protected void onResume() {
        super.onResume();
        RecipeAdapter recipeAdapter = new RecipeAdapter();
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
        cmbRecipe = findViewById(R.id.cmbRecipe);
        ArrayAdapter adapter= new ArrayAdapter(
            this, android.R.layout.simple_spinner_item,
            App.getInstance().getRecipesName().toArray()
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbRecipe.setAdapter(adapter);
    }

    private void setActions(){
    }


}