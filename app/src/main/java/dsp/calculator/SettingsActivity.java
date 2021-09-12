package dsp.calculator;

import static dsp.calculator.bo.Settings.ASSEMBLEUR_MK1;
import static dsp.calculator.bo.Settings.ASSEMBLEUR_MK2;
import static dsp.calculator.bo.Settings.ASSEMBLEUR_MK3;
import static dsp.calculator.bo.Settings.FILE_SETTINGS;
import static dsp.calculator.bo.Settings.KEY_ASSEMBLEUR_RATIO;
import static dsp.calculator.bo.Settings.KEY_SMELTER_RATIO;
import static dsp.calculator.bo.Settings.SMELTER_MK1;
import static dsp.calculator.bo.Settings.SMELTER_MK2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dsp.calculator.bo.Settings;

public class SettingsActivity extends AppCompatActivity {

    private RadioGroup optGroupAssembleur, optGroupSmelter;
    private RadioButton optAssemblerMk1, optAssemblerMk2, optAssemblerMk3;
    private RadioButton optSmelterMk1, optSmelterMk2;
    private Button btnSave, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getViewMembers();
        setActions();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Sélection du radio lié à la valeur
        switch(Settings.getInstance().getAssemblerRatio()){
            case ASSEMBLEUR_MK1: optAssemblerMk1.setChecked(true); break;
            case ASSEMBLEUR_MK2: optAssemblerMk2.setChecked(true); break;
            case ASSEMBLEUR_MK3: optAssemblerMk3.setChecked(true); break;
        }

        //Sélection du radio lié à la valeur
        switch(Settings.getInstance().getSmelterRatio()){
            case SMELTER_MK1: optSmelterMk1.setChecked(true); break;
            case SMELTER_MK2: optSmelterMk2.setChecked(true); break;
        }
    }

    /**
     * Récupération des éléments graphiques du layout
     */
    private void getViewMembers(){
        optGroupAssembleur = findViewById(R.id.optGroupAssembleur);
        optAssemblerMk1 = findViewById(R.id.optionAssemblerMk1);
        optAssemblerMk2 = findViewById(R.id.optionAssemblerMk2);
        optAssemblerMk3 = findViewById(R.id.optionAssemblerMk3);

        optGroupSmelter = findViewById(R.id.optGroupSmelter);
        optSmelterMk1 = findViewById(R.id.optionSmelterMk1);
        optSmelterMk2 = findViewById(R.id.optionSmelterMk2);

        btnSave = findViewById(R.id.btnSave);
        btnReturn = findViewById(R.id.btnReturn);
    }

    /**
     * Actions sur boutons
     */
    private void setActions(){
        btnSave.setOnClickListener((view)->saveSettings());
        btnReturn.setOnClickListener((view)->
                startActivity(new Intent(this, MainActivity.class))
        );
    }

    /**
     * Sauvegarde du paramétrage utilisateur
     */
    protected void saveSettings(){
        switch(optGroupAssembleur.getCheckedRadioButtonId()) {
            case R.id.optionAssemblerMk1:
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).edit().putInt(KEY_ASSEMBLEUR_RATIO, ASSEMBLEUR_MK1).apply();
                break;
            case R.id.optionAssemblerMk2:
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).edit().putInt(KEY_ASSEMBLEUR_RATIO, ASSEMBLEUR_MK2).apply();
                break;
            case R.id.optionAssemblerMk3:
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).edit().putInt(KEY_ASSEMBLEUR_RATIO, ASSEMBLEUR_MK3).apply();
                break;
        }

        switch(optGroupSmelter.getCheckedRadioButtonId()) {
            case R.id.optionSmelterMk1:
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).edit().putInt(KEY_SMELTER_RATIO, SMELTER_MK1).apply();
            case R.id.optionSmelterMk2:
                getSharedPreferences(FILE_SETTINGS, MODE_PRIVATE).edit().putInt(KEY_SMELTER_RATIO, SMELTER_MK2).apply();
        }

        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, MainActivity.class));
    }
}