package my.edu.taruc.lab32inputcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private double basicPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);

        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);
    }

    public void calculatePremium(View view){
        RadioGroup radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);

        int ageIndex = spinnerAge.getSelectedItemPosition();
        boolean ismoker = checkBoxSmoker.isChecked();
        int gender = radioGroupGender.getCheckedRadioButtonId();

        if(gender == R.id.radioButtonMale){
            if(ageIndex == 0 && ismoker == true){
                textViewPremium.setText(Double.toString(basicPremium));
            }
            else if(ageIndex == 1 && ismoker == true){
                textViewPremium.setText(Double.toString(basicPremium));
            }
            else if(ageIndex == 2 && ismoker == true){
                textViewPremium.setText(Double.toString(basicPremium+50));
            }
            else if(ageIndex == 3 && ismoker == true){
                textViewPremium.setText(Double.toString(basicPremium+100+100));
            }
            else if(ageIndex == 4 && ismoker == true){
                textViewPremium.setText(Double.toString(basicPremium+100+150));
            }
            /*else if(ageIndex == 5 && ismoker == true){
                textViewPremium.setText();
            }
            else if(ageIndex == 6 && ismoker == true){
                textViewPremium.setText();
            }
            else if(ageIndex == 7 && ismoker == true){
                textViewPremium.setText();
            }*/
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TODO: calculate basic premium according to age group
        switch (position) {
            case 0:
                basicPremium = 50;
                break;
            case 1:
                basicPremium = 55;
                break;
            case 2:
                basicPremium = 60;
                break;
            case 3:
                basicPremium = 70;
                break;
            case 4:
                basicPremium = 120;
                break;
            case 5:
                basicPremium = 160;
                break;
            case 6:
                basicPremium = 200;
                break;
            case 7:
                basicPremium = 250;
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
