package dsp.calculator.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.enums.RecipeNames;

@Dao
public abstract class RecipeDao {
    @Insert
    protected abstract long insert(Recipe recipe);

    @Insert
    protected abstract void insertConsumptionList(List<Consumption> consumptions);

    @Query("SELECT * FROM Recipe")
    protected abstract List<Recipe> selectAll();

    @Query("SELECT * FROM Recipe WHERE id =:id")
    protected abstract Recipe selectById(long id);

    @Query("SELECT * FROM Recipe WHERE name =:name")
    protected abstract List<Recipe> selectByName(String name);

    @Query("SELECT * FROM Consumption WHERE recipeId =:recipeId")
    protected abstract List<Consumption> getConsumptionList(long recipeId);

    public void add (Recipe recipe) {
        long newId = insert(recipe);
        recipe.setId(newId);
        for (Consumption c : recipe.getConsumptions()) {
            c.setRecipeId(newId);
        }
        insertConsumptionList(recipe.getConsumptions());
    }

    public Recipe getById (long recipeId) {
        Recipe recipe = selectById(recipeId);
        List<Consumption> consumptions = getConsumptionList(recipe.getId());
        recipe.setConsumptions(consumptions);
        return recipe;
    }

    public List<Recipe> getByName (String recipeName) {
        List<Recipe> recipes = selectByName(recipeName);
        for (Recipe r : recipes) {
            List<Consumption> consumptions = getConsumptionList(r.getId());
            r.setConsumptions(consumptions);
        }
        return recipes;
    }

    public List<Recipe> getAll() {
        List<Recipe> recipes = selectAll();
        for (Recipe r : recipes) {
            List<Consumption> consumptions = getConsumptionList(r.getId());
            r.setConsumptions(consumptions);
        }
        return recipes;
    }
}