package sg.edu.rp.c346.demomyprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Saved", strName);

        float fGPA = Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit1 = prefs1.edit();
        prefEdit1.putFloat("Saved1", fGPA);

        int btn = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit2 = prefs2.edit();
        prefEdit2.putInt("Saved2", btn);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("Saved", "Not Saved");
        etName.setText("Saved");

        SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(this);
        float msg1 = prefs1.getFloat("Saved1", 0.0f);
        etGPA.setText("Saved1");

        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(this);
        int msg2 = prefs2.getInt("Saved2", 0);
        rgGender.clearCheck();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);

    }
}
