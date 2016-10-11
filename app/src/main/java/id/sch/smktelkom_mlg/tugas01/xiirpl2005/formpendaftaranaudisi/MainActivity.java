package id.sch.smktelkom_mlg.tugas01.xiirpl2005.formpendaftaranaudisi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etNationality;
    Button bSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editTextName);
        etNationality = (EditText) findViewById(R.id.editTextNationality);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        tvResult = (TextView) findViewById(R.id.textViewResult);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String nationality = etNationality.getText().toString();
                tvResult.setText("Your name :" + name + "Nationality :" + nationality);
            }
        });
    }
}
