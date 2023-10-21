package dsp.calculator.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dsp.calculator.App;
import dsp.calculator.Datas;
import dsp.calculator.R;
import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.databinding.AlternativeListItemBinding;

public class RecipesWithAlternativesListAdapter extends RecyclerView.Adapter<RecipesWithAlternativesListAdapter.AlternativeListItemHolder> {
    List<String> recipesWithAlternatives = new ArrayList<>();
    public void setRecipesWithAlternatives(List<String> alternativesRecipe) {
        this.recipesWithAlternatives = alternativesRecipe;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull AlternativeListItemHolder holder, int position) {
        String recipeName = recipesWithAlternatives.get(position);
        holder.bind(recipeName);
    }
    @Override
    public int getItemCount() {
        return recipesWithAlternatives.size();
    }

    @NonNull
    @Override
    public AlternativeListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AlternativeListItemBinding recipeView = AlternativeListItemBinding.inflate(
                layoutInflater, parent, false);
        return new AlternativeListItemHolder(recipeView);
    }

    protected static class AlternativeListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AlternativeListItemBinding viewElements;
        List<Recipe> alternatives;
        public AlternativeListItemHolder(@NonNull AlternativeListItemBinding itemView){
            //Récupération de la vue du binding fourni et transmission de la vue au constructeur parent
            super(itemView.getRoot());
            //On récupère le binding dans la classe
            viewElements = itemView;
        }

        //méthode d'association de la vue et des valeurs d'un élément + définition des actions des boutons si besoin
        public void bind(final String recipeName) {
            alternatives = Datas.get().getByName(recipeName);
            long alternativeId = App.get().getSettings().getAlternative(recipeName);
            switch(alternatives.size()) {
                case 3:
                    viewElements.imgAlt3.setImageResource(alternatives.get(2).getImageId());
                    viewElements.txtAlt3.setText(alternatives.get(2).getConsumptionDetails());
                    if(alternativeId == alternatives.get(2).getId())
                        viewElements.switchAlt3.setChecked(true);
                case 2:
                    viewElements.imgAlt2.setImageResource(alternatives.get(1).getImageId());
                    viewElements.txtAlt2.setText(alternatives.get(1).getConsumptionDetails());
                    if(alternativeId == alternatives.get(1).getId())
                        viewElements.switchAlt2.setChecked(true);
                case 1:
                    viewElements.imgAlt1.setImageResource(alternatives.get(0).getImageId());
                    viewElements.txtAlt1.setText(alternatives.get(0).getConsumptionDetails());
                    if(alternativeId == alternatives.get(0).getId())
                        viewElements.switchAlt1.setChecked(true);
            }
            viewElements.switchAlt1.setOnClickListener(this);
            viewElements.switchAlt2.setOnClickListener(this);
            viewElements.switchAlt3.setOnClickListener(this);
            setHeight(alternatives.size());
        }
        @Override
        public void onClick(View view) {
            if(view.getId() != viewElements.switchAlt1.getId())
                viewElements.switchAlt1.setChecked(false);

            if(view.getId() != viewElements.switchAlt2.getId())
                viewElements.switchAlt2.setChecked(false);

            if(view.getId() != viewElements.switchAlt3.getId())
                viewElements.switchAlt3.setChecked(false);

            switch(view.getId()) {
//                case R.id.switchAlt1: App.get().getSettings().setAlternative(alternatives.get(0)); break;
//                case R.id.switchAlt2: App.get().getSettings().setAlternative(alternatives.get(1)); break;
//                case R.id.switchAlt3: App.get().getSettings().setAlternative(alternatives.get(2)); break;
            }
        }
        private void setHeight(int countOfAlternativesToDisplay){
            switch (countOfAlternativesToDisplay){
                case 1:
                    viewElements.row2.removeAllViews();
                case 2:
                    viewElements.row3.removeAllViews();
            }
        }
    }
}
