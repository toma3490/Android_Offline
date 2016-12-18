package com.android.toma.offline_22;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static final String COLOR = "color";

    private Button blue;
    private Button green;
    private Button violet;

    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        blue = (Button) findViewById(R.id.blue);
        green = (Button) findViewById(R.id.green);
        violet = (Button) findViewById(R.id.violet);
        layout = (RelativeLayout) findViewById(R.id.main);


        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.green));
            }
        });

        violet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.violet));
            }
        });
    }

    private int getColor(View view){
        ColorDrawable viewColor = (ColorDrawable) view.getBackground();
        return viewColor.getColor();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        layout.setBackgroundColor((Integer) savedInstanceState.get(COLOR));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COLOR, getColor(layout));
    }
}
