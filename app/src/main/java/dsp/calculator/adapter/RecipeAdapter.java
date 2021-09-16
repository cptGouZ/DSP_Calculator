package dsp.calculator.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dsp.calculator.bo.Recipe;
import dsp.calculator.bo.RecipeCalculation;
import dsp.calculator.databinding.RecipeLayoutBinding;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {
    List<RecipeCalculation> recipesToDisplay = new ArrayList<>();

    public void setRecipesToDisplay(List<RecipeCalculation> recipesToDisplay) {
        this.recipesToDisplay = recipesToDisplay;
        notifyDataSetChanged();
    }

    /**
     * Méthode permettant de passer l'instance du BO au ViewHolder pour chaque item à afficher
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        RecipeCalculation recipe = recipesToDisplay.get(position);
        holder.bind(recipe);
    }

    @Override
    public int getItemCount() {
        return recipesToDisplay.size();
    }

    /**
     * A la création de la classe on définie la layout à utiliser pour l'affichage du BO
     * Ici le "recipe_layout" sera converti en objet Java par le RecipeHolder
     */
    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecipeLayoutBinding recipeView = RecipeLayoutBinding.inflate(
                layoutInflater, parent, false);
        return new RecipeHolder(recipeView);
    }

    /**
     * Représentation Java d'un item présent dans le recycler view.
     * Il est en corrélation avec le Layout fourni lors de la création de l'adapter
     * et qui sera ensuite affiché à l'écran
     */
    protected static class RecipeHolder extends RecyclerView.ViewHolder {
        RecipeLayoutBinding viewElements;
        public RecipeHolder(@NonNull RecipeLayoutBinding itemView){
            //Récupération de la vue du binding fourni et transmission de la vue au constructeur parent
            super(itemView.getRoot());
            //On récupère le binding dans la classe
            viewElements = itemView;
        }

        //méthode d'association de la vue et des valeurs d'un élément + définition des actions des bouton si besoin
        public void bind(final RecipeCalculation recipe) {
            viewElements.txtProductionRate.setText(String.valueOf(recipe.getProductionRate()));
            viewElements.txtConsumptionRate.setText(String.valueOf(recipe.getConsumptionAsked()));
            viewElements.txtFacilityType.setText(recipe.getRecipe().getFacilityType());
            viewElements.txtFacilityNeeded.setText(String.valueOf(recipe.getFacilityCount()));
            viewElements.imgRecipe.setImageResource(recipe.getRecipe().getImageId());
            //viewElements.executePendingBindings();
        }
    }
}
