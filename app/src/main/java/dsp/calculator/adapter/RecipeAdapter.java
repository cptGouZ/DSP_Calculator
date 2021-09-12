package dsp.calculator.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dsp.calculator.R;
import dsp.calculator.bo.Recipe;
import dsp.calculator.controller.App;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {

    public RecipeAdapter() {
    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View recipeView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recipe_layout, parent, false
        );
        return new RecipeHolder(recipeView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Recipe recipe = App.getInstance().getRecipes().get(position);
        holder.txtConsumptionRate.setText(String.valueOf(recipe.getRateByMinute()));
        holder.txtProductionRate.setText(String.valueOf(recipe.getRateByMinute()));
        holder.txtFacilityType.setText(String.valueOf(recipe.getFacilityType()));
        holder.txtFacilityNeeded.setText(String.valueOf(recipe.getId()));
    }

    @Override
    public int getItemCount() {
        return App.getInstance().getRecipes().size();
    }
}
