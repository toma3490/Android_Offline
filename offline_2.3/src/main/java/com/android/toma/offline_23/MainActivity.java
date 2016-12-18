package com.android.toma.offline_23;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.appcompat.BuildConfig;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private Button add;
    private Button reset;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editName = (EditText) findViewById(R.id.editName);
        add = (Button) findViewById(R.id.add);
        reset = (Button) findViewById(R.id.reset);
        name = (TextView) findViewById(R.id.name);

        load();
//        final String getShared = sharedPreferences.getString("NAME", "There is no data yet");// второй параметр Эррор, что мы будем выводить, если ничего нет в шаред преференс

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(BuildConfig.VERSION_NAME, Context.MODE_PRIVATE);
                sharedPreferences.edit().putString("NAME", String.valueOf(editName.getText())).apply();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(BuildConfig.VERSION_NAME, Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();
            }
        });
    }

    private void load(){
        SharedPreferences sharedPreferences = getSharedPreferences(BuildConfig.VERSION_NAME, Context.MODE_PRIVATE);
        String sharedName = sharedPreferences.getString("NAME", null);
        if(sharedName != null){
            name.setText(sharedName);
        }else {
            Toast.makeText(MainActivity.this, "There is no data yet", Toast.LENGTH_SHORT).show();
        }
    }
}
