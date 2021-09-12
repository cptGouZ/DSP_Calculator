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
    protected abstract long insertRecipe(Recipe recipe);

    @Insert
    protected abstract long[] insertConsumptionList(List<Consumption> consumptions);

    @Query("SELECT * FROM Recipe WHERE id =:id")
    protected abstract Recipe getRecipe(long id);

    @Query("SELECT * FROM Consumption WHERE recipeId =:recipeId")
    protected abstract List<Consumption> getConsumptionList(long recipeId);

    public void insertRecipeWithConsumptions(Recipe recipe) {
        recipe.setId(insertRecipe(recipe));
        for (Consumption c : recipe.getConsumptions()) {
            c.setRecipeId(recipe.getId());
        }
        insertConsumptionList(recipe.getConsumptions());
    }

    public Recipe getRecipeWithConsumptions(long recipeId) {
        Recipe recipe = getRecipe(recipeId);
        List<Consumption> consumptions = getConsumptionList(recipeId);
        recipe.setConsumptions(consumptions);
        return recipe;
    }
}