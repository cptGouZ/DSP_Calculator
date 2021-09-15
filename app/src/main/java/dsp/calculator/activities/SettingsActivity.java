package dsp.calculator.activities;

import static dsp.calculator.Settings.ASSEMBLEUR_MK1;
import static dsp.calculator.Settings.ASSEMBLEUR_MK2;
import static dsp.calculator.Settings.ASSEMBLEUR_MK3;
import static dsp.calculator.Settings.SMELTER_MK1;
import static dsp.calculator.Settings.SMELTER_MK2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dsp.calculator.R;
import dsp.calculator.App;

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
        switch(App.getInstance().getSettings().getAssemblerRatio()){
            case ASSEMBLEUR_MK1: optAssemblerMk1.setChecked(true); break;
            case ASSEMBLEUR_MK2: optAssemblerMk2.setChecked(true); break;
            case ASSEMBLEUR_MK3: optAssemblerMk3.setChecked(true); break;
        }

        //Sélection du radio lié à la valeur
        switch(App.getInstance().getSettings().getSmelterRatio()){
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
        btnSave.setOnClickListener((view)-> {
                App.getInstance().getSettings().save(
                        optGroupAssembleur.getCheckedRadioButtonId(),
                        optGroupSmelter.getCheckedRadioButtonId()
                );
                Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }
        );
        btnReturn.setOnClickListener((view)->
                startActivity(new Intent(this, MainActivity.class))
        );
    }


}