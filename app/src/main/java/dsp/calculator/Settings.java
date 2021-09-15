package dsp.calculator;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dsp.calculator.R;
import dsp.calculator.databinding.ActivitySettingsBinding;

public class Settings {
    public static final String FILE_SETTINGS = "settings";
    public static final String KEY_ASSEMBLEUR_RATIO = "assembleur_ratio";
    public static final String KEY_SMELTER_RATIO = "smelter_ratio";
    public static final int ASSEMBLEUR_MK1 = 75;
    public static final int ASSEMBLEUR_MK2 = 100;
    public static final int ASSEMBLEUR_MK3 = 150;
    public static final int SMELTER_MK1 = 100;
    public static final int SMELTER_MK2 = 200;

    private Context context;
    private int assemblerRatio;
    private int smelterRatio;

    private ActivitySettingsBinding binding;

    Settings(Context context){
        this.context = context;
    }

    public int getAssemblerRatio() {
        int value = context.getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).getInt(KEY_ASSEMBLEUR_RATIO, 0);
        if(assemblerRatio == 0)
            value = ASSEMBLEUR_MK1;
        return value;
    }

    private void setAssemblerRatio(int assemblerRatio) {
         context.getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE)
                .edit()
                .putInt(KEY_ASSEMBLEUR_RATIO, assemblerRatio)
                .apply();
        this.assemblerRatio = assemblerRatio;
    }

    public int getSmelterRatio() {
        int value = context.getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).getInt(KEY_SMELTER_RATIO, 0);
        if(smelterRatio == 0)
            value = SMELTER_MK1;
        return value;
    }

    private void setSmelterRatio(int smelterRatio) {
        context.getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE)
                .edit()
                .putInt(KEY_SMELTER_RATIO, smelterRatio)
                .apply();
        this.smelterRatio = smelterRatio;
    }

    public void save(int selectedAssembler, int selectedSmelter ){
        switch(selectedAssembler) {
            case R.id.optionAssemblerMk1: setAssemblerRatio(ASSEMBLEUR_MK1); break;
            case R.id.optionAssemblerMk2: setAssemblerRatio(ASSEMBLEUR_MK2); break;
            case R.id.optionAssemblerMk3: setAssemblerRatio(ASSEMBLEUR_MK3); break;
        }

        switch(selectedSmelter) {
            case R.id.optionSmelterMk1: setSmelterRatio(SMELTER_MK1); break;
            case R.id.optionSmelterMk2: setSmelterRatio(SMELTER_MK2); break;
        }
    }
}
