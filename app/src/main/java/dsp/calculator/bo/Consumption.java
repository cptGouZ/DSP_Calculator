package dsp.calculator.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consumption {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long recipeId;
    private String consumedRecipeName;
    private float rate;
}
