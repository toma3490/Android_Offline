package com.android.toma.offline_1;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView modulo;
    private EditText editNumber;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        modulo = (TextView) findViewById(R.id.modulo);
        editNumber = (EditText) findViewById(R.id.editNumber);
        button = (Button) findViewById(R.id.button);
    }



    public void modul(View view){
        int number = 0;
        if(editNumber.length() > 0){
            number = Integer.parseInt(editNumber.getText().toString());
        }
        int result = number % 10;
        int result1 = number / 10;
        int result2 = number * 1234;
        Toast.makeText(getApplicationContext(), String.valueOf(result1), Toast.LENGTH_SHORT).show();
        modulo.setText(String.valueOf(result));
        Log.d("LOG_TAG", String.valueOf(result2));
        Snackbar.make(view, String.valueOf(23), Snackbar.LENGTH_SHORT).show();

    }
}
