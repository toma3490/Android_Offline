package com.android.toma.offline;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editPhoneNumber;
    private Button callBtn;
    private EditText editLongitude;
    private EditText editLatitude;
    private Button findBtn;
    private EditText editAdress;
    private Button siteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editPhoneNumber = (EditText) findViewById(R.id.editNumber);
        editLongitude = (EditText) findViewById(R.id.editLongitude);
        editLatitude = (EditText) findViewById(R.id.editLatitude);
        findBtn = (Button) findViewById(R.id.findBtn);
        callBtn = (Button) findViewById(R.id.callBtn);
        editAdress = (EditText) findViewById(R.id.editSite);
        siteBtn = (Button) findViewById(R.id.siteBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telNumber = "tel:" + editPhoneNumber.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(telNumber));
                startActivity(intent);
            }
        });

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coordinates = "geo:" + editLatitude.getText().toString() + "," + editLongitude.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(coordinates));
                startActivity(intent);
            }
        });

        siteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String siteAdress = "http://" + editAdress.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(siteAdress));
                startActivity(intent);
            }
        });
    }
}
