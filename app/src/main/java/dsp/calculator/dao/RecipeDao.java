package dsp.calculator.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;

@Dao
public abstract class RecipeDao {
    @Insert
    public abstract void insertRecipe(Recipe recipe);

    @Insert
    public abstract void insertConsumptionList(List<Consumption> consumptions);

    @Query("SELECT * FROM Recipe WHERE name =:name")
    public abstract Recipe getRecipe(String name);

    @Query("SELECT * FROM Consumption WHERE recipeName =:recipeName")
    public abstract List<Consumption> getConsumptionList(String recipeName);

    public void insertRecipeWithConsumptions(Recipe recipe) {
        for (Consumption c : recipe.getConsumptions()) {
            c.setRecipeName(recipe.getName());
        }
        insertConsumptionList(recipe.getConsumptions());
        insertRecipe(recipe);
    }

    public Recipe getRecipeWithConsumptions(String recipeName) {
        Recipe recipe = getRecipe(recipeName);
        List<Consumption> consumptions = getConsumptionList(recipeName);
        recipe.setConsumptions(consumptions);
        return recipe;
    }
}