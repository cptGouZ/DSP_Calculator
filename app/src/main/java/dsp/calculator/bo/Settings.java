package dsp.calculator.bo;

public class Settings {
    public static final String FILE_SETTINGS = "settings";
    public static final String KEY_ASSEMBLEUR_RATIO = "assembleur_ratio";
    public static final String KEY_SMELTER_RATIO = "smelter_ratio";
    public static final int ASSEMBLEUR_MK1 = 75;
    public static final int ASSEMBLEUR_MK2 = 100;
    public static final int ASSEMBLEUR_MK3 = 150;
    public static final int SMELTER_MK1 = 100;
    public static final int SMELTER_MK2 = 200;

    private static Settings instance;
    private int assemblerRatio;
    private int smelterRatio;

    private Settings(){}
    public static Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }

    public int getAssemblerRatio() {
        int value = assemblerRatio;
        if(assemblerRatio == 0)
            value = ASSEMBLEUR_MK1;
        return value;
    }

    public void setAssemblerRatio(int assemblerRatio) {
        this.assemblerRatio = assemblerRatio;
    }

    public int getSmelterRatio() {
        int value = smelterRatio;
        if(smelterRatio == 0)
            value = SMELTER_MK1;
        return value;
    }

    public void setSmelterRatio(int smelterRatio) {
        this.smelterRatio = smelterRatio;
    }
}
