package dsp.calculator.bo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe{
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String facilityType;
    private float rateByMinute;
    @Ignore
    private List<Consumption> consumptions = new ArrayList<>();

    public Recipe(String name, String facilityType, float rateByMinute, List<Consumption> consumptions) {
        this.name = name;
        this.facilityType = facilityType;
        this.rateByMinute = rateByMinute;
        this.consumptions = consumptions;
    }
}
