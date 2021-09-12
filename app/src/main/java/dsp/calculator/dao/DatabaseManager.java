package dsp.calculator.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dsp.calculator.bo.Consumption;
import dsp.calculator.bo.Recipe;

@Database(entities = {Consumption.class, Recipe.class}, version=1, exportSchema = false)
public abstract class DatabaseManager extends RoomDatabase {
    //DAO
    public abstract RecipeDao recipeDao();
    //Singleton
    private static volatile DatabaseManager instance;
    public static DatabaseManager getInstance(Context context){
        if(instance==null){
            synchronized (DatabaseManager.class){
                if(instance == null){
                    instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DatabaseManager.class, "dsp_db.db"
                        ).build();
                }
            }
        }
        return instance;
    }
}