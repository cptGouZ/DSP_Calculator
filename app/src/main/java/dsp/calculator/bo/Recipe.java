package dsp.calculator.bo;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import dsp.calculator.App;
import dsp.calculator.enums.FacilityTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe implements Comparable<Recipe> {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String facilityType;
    private float rateByMinute;
    private String pictureAltName;
    @Ignore
    private List<Consumption> consumptions = new ArrayList<>();

    public Recipe(String name, String facilityType, float rateByMinute, String pictureAltName, List<Consumption> consumptions) {
        this.name = name;
        this.facilityType = facilityType;
        this.rateByMinute = rateByMinute;
        this.consumptions = consumptions;
        this.pictureAltName = pictureAltName;
    }

    public float getRateByMinute(){
        float ratioProd = 100;
        if(FacilityTypes.ASSEMBLER.equals(facilityType)){
            ratioProd = App.getInstance().getSettings().getAssemblerRatio();
        }
        if(FacilityTypes.SMELTER.equals(facilityType)){
            ratioProd = App.getInstance().getSettings().getSmelterRatio();
        }
        return rateByMinute * ratioProd / 100;
    }

    public int getImageId() {
        Context c = App.getContext();
        return c.getResources().getIdentifier(
                getPictureAltName(),
                "mipmap",
                c.getPackageName());
    }

    @Override
    public int compareTo(Recipe recipe) {
        if(recipe.id > this.id) return 1;
        if(recipe.id < this.id) return -1;
        return 0;
    }
}