package dsp.calculator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import dsp.calculator.bo.Recipe;
import dsp.calculator.databinding.RecipeSpinnerDropdownLayoutBinding;

public class SpinnerItemAdapter extends ArrayAdapter<Recipe> {

    private RecipeSpinnerDropdownLayoutBinding recipeView;

    public SpinnerItemAdapter(Context context, int layoutId, List<Recipe> itemList){
        super(context, layoutId, itemList);
    }

    @Override
    public boolean isEnabled(int position){
        if(position == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    //Eléments afficher dans le menu déroulant
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        recipeView = RecipeSpinnerDropdownLayoutBinding.inflate(
                layoutInflater, parent, false);
        Recipe recipe = getItem(position);
        recipeView.imageView.setImageResource(recipe.getImageId());
        recipeView.txtSpinnerRecipeName.setText(recipe.getName());
        return recipeView.getRoot();
    }

    //C'est la vue affiché sur la page principele
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View w =  super.getView(position, convertView, parent);
        ((TextView)w).setText(getItem(position).getName());
        return w;
    }

}