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
    @PrimaryKey
    @NonNull
    private String name;
    private float rateByMinute;
    private float alternativeRateByMinute;
    private String facilityType;
    @Ignore
    private List<Consumption> consumptions = new ArrayList<>();

    public Recipe(@NonNull String name, float rateByMinute, float alternativeRateByMinute, String facilityType) {
        this.name = name;
        this.rateByMinute = rateByMinute;
        this.alternativeRateByMinute = alternativeRateByMinute;
        this.facilityType = facilityType;
    }
}
