package dsp.calculator.adapter;

import android.util.Log;
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
    List<Recipe> recipesToDisplay;
    public RecipeAdapter(List<Recipe> recipesToDisplay) {
        this.recipesToDisplay = recipesToDisplay;
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
        Recipe recipe = recipesToDisplay.get(position);
        holder.txtConsumptionRate.setText(String.valueOf(recipe.getRateByMinute()));
        holder.txtProductionRate.setText(String.valueOf(recipe.getRateByMinute()));
        holder.txtFacilityType.setText(String.valueOf(recipe.getFacilityType()));
        holder.txtFacilityNeeded.setText(String.valueOf(recipe.getId()));
        int drawableResourceId = App.getInstance().getContext().getResources().getIdentifier(
                recipe.getPictureAltName(),
                "mipmap",
                App.getInstance().getContext().getPackageName()
        );
        holder.imgRecipe.setImageResource(drawableResourceId);
    }

    @Override
    public int getItemCount() {
        return recipesToDisplay.size();
    }
}
