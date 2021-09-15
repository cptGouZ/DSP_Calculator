package dsp.calculator.dao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;
import dsp.calculator.App;

@Database(entities = {Consumption.class, Recipe.class}, version=1, exportSchema = false)
public abstract class DatabaseManager extends RoomDatabase {
    //DAO
    public abstract RecipeDao recipeDao();
    //Singleton
    private static volatile DatabaseManager instance;
    public static DatabaseManager getInstance(){
        if(instance==null){
            synchronized (DatabaseManager.class){
                if(instance == null){
                    instance = Room.databaseBuilder(
                            App.getContext().getApplicationContext(),
                            DatabaseManager.class, "dsp_db.db"
                        ).build();
                }
            }
        }
        return instance;
    }
}
