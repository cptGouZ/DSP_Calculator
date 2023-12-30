package dsp.calculator.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
