package dsp.calculator;

import android.content.SharedPreferences;

import dsp.calculator.bo.Recipe;
import dsp.calculator.enums.CalculMode;

public class Settings {
    public static final String FILE_SETTINGS = "settings";
    public static final String KEY_ASSEMBLEUR_RATIO = "assembleur_ratio";
    public static final String KEY_SMELTER_RATIO = "smelter_ratio";
    public static final int ASSEMBLEUR_MK1 = 75;
    public static final int ASSEMBLEUR_MK2 = 100;
    public static final int ASSEMBLEUR_MK3 = 150;
    public static final int SMELTER_MK1 = 100;
    public static final int SMELTER_MK2 = 200;
    public static final String CALCUL_MODE = "calcul_mode";

    private SharedPreferences sp;

    Settings(SharedPreferences sharedPreferences){
        this.sp = sharedPreferences;
    }

    public int getAssemblerRatio() {
        int value = sp.getInt(KEY_ASSEMBLEUR_RATIO, 0);
        if(value == 0)
            value = ASSEMBLEUR_MK1;
        return value;
    }

    private void setAssemblerRatio(int assemblerRatio) {
        sp.edit()
            .putInt(KEY_ASSEMBLEUR_RATIO, assemblerRatio)
            .apply();
    }

    public int getSmelterRatio() {
        int value = sp.getInt(KEY_SMELTER_RATIO, 0);
        if(value == 0)
            value = SMELTER_MK1;
        return value;
    }

    private void setSmelterRatio(int smelterRatio) {
        sp.edit()
            .putInt(KEY_SMELTER_RATIO, smelterRatio)
            .apply();
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

    public void setAlternative(Recipe r){
        sp.edit()
            .putLong(r.getName(), r.getId())
            .apply();
    }
    public Long getAlternative(String recipeName){
        Long value = sp.getLong(recipeName, 0);
        if(value == 0)
            value = Datas.get().getByName(recipeName).get(0).getId();
        return value;
    }

    public int getCalculMode(){
        return sp.getInt(CALCUL_MODE,0);
    }

    public void setCalculMode(int mode){
        sp.edit()
            .putInt(CALCUL_MODE, mode)
            .apply();
    }
}
