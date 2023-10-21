package dsp.calculator.bo;

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

}
