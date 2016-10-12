package id.sch.smktelkom_mlg.tugas01.xiirpl2005.formpendaftaranaudisi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etNationality;
    //    RadioButton rbM, rbF;
    CheckBox cbS, cbD, cbR, cbA;
    Button bSubmit;
    TextView tvResult;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editTextName);
        etNationality = (EditText) findViewById(R.id.editTextNationality);
        rg = (RadioGroup) findViewById(R.id.radioGroupAbility);

        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        cbD = (CheckBox) findViewById(R.id.checkBoxD);
        cbR = (CheckBox) findViewById(R.id.checkBoxR);
        cbA = (CheckBox) findViewById(R.id.checkBoxA);

        bSubmit = (Button) findViewById(R.id.buttonSubmit);

        tvResult = (TextView) findViewById(R.id.textViewResult);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
//                doClick();
            }
        });
    }

    /*private void doClick()
    {
            String result = null;

            if (rbS.isChecked())
            {
                result = rbS.getText().toString();
            }
            else if(rbD.isChecked())
            {
                result = rbD.getText().toString();
            }
            else if(rbR.isChecked())
            {
                result = rbR.getText().toString();
            }
            else if(rbA.isChecked())
            {
                result = rbA.getText().toString();
            }

            if (result == null)
            {
                tvResult.setText("Please choose your ability");
            }
            else
            {
                tvResult.setText(result);
            }
    }*/

    //process button
    private void doProcess() {
        if (isValid()) {
            String hsl = null;
            if (rg.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rg.getCheckedRadioButtonId());
                hsl = rb.getText().toString();
            }

            String name = etName.getText().toString();
            String nationality = etNationality.getText().toString();


            String rslt = "\nAbility : \n ";
            int startlen = rslt.length();
            if (cbS.isChecked()) rslt += cbS.getText() + "\n";
            if (cbD.isChecked()) rslt += cbD.getText() + "\n";
            if (cbR.isChecked()) rslt += cbR.getText() + "\n";
            if (cbA.isChecked()) rslt += cbA.getText() + "\n";
            if (rslt.length() == startlen) rslt += "Please select your ability";

            if (hsl == null) {
                tvResult.setText("Please choose your gender");
            } else
                tvResult.setText("Your name : " + name + "\nNationality : " + nationality + "\nGender : " + hsl + rslt);
        }
        }

    //validation
    private boolean isValid() {
        boolean valid = true;

        String name = etName.getText().toString();
        String nationality = etNationality.getText().toString();

        if (name.isEmpty()) {
            etName.setError("Please insert your name");
            valid = false;
        } else if (name.length() < 3) {
            etName.setError("Please type your full name");
            valid = false;
        } else {
            etName.setError(null);
        }
        if (nationality.isEmpty()) {
            etNationality.setError("Please insert your Nationality");
            valid = false;
        } else {
            etNationality.setError(null);
        }
        return valid;
    }
}
