package com.android.toma.offline_32;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnotherActivity extends AppCompatActivity {
    private static final int TEST_REQUEST = 111;
    public static final String TEXT_TEXT = "text_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_1);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(AnotherActivity.TEXT_TEXT, "Hello");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
