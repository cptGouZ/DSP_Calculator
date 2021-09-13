package dsp.calculator.adapter;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dsp.calculator.R;

public class RecipeHolder extends RecyclerView.ViewHolder {
    //Déclaration des éléments
    TextView txtProductionRate;
    TextView txtConsumptionRate;
    TextView txtFacilityNeeded;
    TextView txtFacilityType;
    ImageView imgRecipe;
    public RecipeHolder(@NonNull View itemView){
        super(itemView);
        //Récupération des éléments à partir de la vue
        txtProductionRate = (TextView) itemView.findViewById(R.id.txtProductionRate);
        txtConsumptionRate = (TextView) itemView.findViewById(R.id.txtConsumptionRate);
        txtFacilityNeeded = (TextView) itemView.findViewById(R.id.txtFacilityNeeded);
        txtFacilityType = (TextView) itemView.findViewById(R.id.txtFacilityType);
        imgRecipe = (ImageView) itemView.findViewById(R.id.imgRecipe);
    }
}
