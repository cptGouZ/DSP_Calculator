package dsp.calculator.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import dsp.calculator.Datas;
import dsp.calculator.adapters.RecipesWithAlternativesListAdapter;
import dsp.calculator.databinding.AlternativeListBinding;

public class AlternativeActivity extends AppCompatActivity {
    AlternativeListBinding binding;
    RecipesWithAlternativesListAdapter recipesWithAlternativesListAdapter = new RecipesWithAlternativesListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AlternativeListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recipesWithAlternativesListAdapter.setRecipesWithAlternatives(Datas.get().getRecipeNamesWithAlternatives());
        binding.recipeWithAlternativesList.setLayoutManager(new LinearLayoutManager(this));
        binding.recipeWithAlternativesList.setAdapter(recipesWithAlternativesListAdapter);

        binding.btnBack.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }
}