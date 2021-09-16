package dsp.calculator.bo;

import dsp.calculator.App;
import dsp.calculator.Settings;
import dsp.calculator.enums.FacilityTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeCalculation {
    private Recipe recipe;
    private float consumptionAsked;

    public int getFacilityCount(){
        return (int)Math.ceil(consumptionAsked/recipe.getRateByMinute());
    }

    public float getProductionRate(){
        return recipe.getRateByMinute() * getFacilityCount();
    }

    public float getDeltaProductionConsumtion(){
        return getProductionRate()-consumptionAsked;
    }
}
