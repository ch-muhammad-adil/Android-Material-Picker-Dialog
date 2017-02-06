package adil.dev.lib.material_number_picker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import adil.dev.lib.materialnumberpicker.dialog.GenderPickerDialog;
import adil.dev.lib.materialnumberpicker.dialog.NumberPickerDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.number_picker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPickerDialog dialog=new NumberPickerDialog(MainActivity.this, 0, 24, new NumberPickerDialog.NumberPickerCallBack() {
                    @Override
                    public void onSelectingValue(int value) {

                    }
                });
                dialog.show();
            }
        });
        findViewById(R.id.gender_picker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenderPickerDialog dialog=new GenderPickerDialog(MainActivity.this);
                dialog.setOnSelectingGender(new GenderPickerDialog.OnGenderSelectListener() {
                    @Override
                    public void onSelectingGender(String value) {

                    }
                });
                dialog.show();
            }
        });
    }
}
