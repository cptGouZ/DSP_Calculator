package dsp.calculator.bo;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dsp.calculator.App;
import dsp.calculator.Datas;
import dsp.calculator.Settings;
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

    public float getRateByMinute(){
        float ratioProd = 100;
        if(FacilityTypes.ASSEMBLER.equals(facilityType)){
            ratioProd = App.get().getSettings().getAssemblerRatio();
        }
        if(FacilityTypes.SMELTER.equals(facilityType)){
            ratioProd = App.get().getSettings().getSmelterRatio();
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

    public String getConsumptionDetails(){
        StringBuilder sb = new StringBuilder();
        for (Consumption c : consumptions) {
            if(sb.length()!=0)
                sb.append("\n");
            sb.append("needs ")
                .append(c.getRate())
                .append(" ")
                .append(c.getConsumedRecipeName());
        }
        if(sb.length()!=0)
            sb.append("\n");
        sb.append("Made in ")
            .append(facilityType);
        return sb.toString();
    }

    @Override
    public int compareTo(Recipe recipe) {
        if(recipe.id > this.id) return 1;
        if(recipe.id < this.id) return -1;
        return 0;
    }

    public int getNbFacilitiyInLineMK1(){
        float maxBeltUsage = this.getMaxBeltUsage();
        return (int)Math.ceil(Settings.BELT_MK1 / maxBeltUsage);
    }
    public int getNbFacilitiyInLineMK2(){
        float maxBeltUsage = this.getMaxBeltUsage();
        return (int)Math.ceil(Settings.BELT_MK2 / maxBeltUsage);
    }
    public int getNbFacilitiyInLineMK3(){
        float maxBeltUsage = this.getMaxBeltUsage();
        return (int)Math.ceil(Settings.BELT_MK3 / maxBeltUsage);
    }
    private float getMaxBeltUsage (){
        float maxBeltUsage = 0;
        float beltUsage = 0;
        for (Consumption c : this.getConsumptions()) {
            beltUsage = this.getRateByMinute() * c.getRate();
            maxBeltUsage = Math.max(maxBeltUsage, beltUsage);
        }
        return maxBeltUsage;
    }
}