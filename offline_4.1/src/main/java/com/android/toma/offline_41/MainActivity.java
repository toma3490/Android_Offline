package com.android.toma.offline_41;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 43;
    private Button mTakePhotoBtn;
    private Uri fileUri;
    private ImageView original;
    private ImageView treated;
    private TextView infoOriginal;
    private TextView infoTreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        original = (ImageView) findViewById(R.id.imageViewCamera);
        treated = (ImageView) findViewById(R.id.imageViewTreated);

        infoOriginal = (TextView) findViewById(R.id.originalHW);
        infoTreated = (TextView) findViewById(R.id.treadedHW);

        mTakePhotoBtn = (Button) findViewById(R.id.takePhotoBtn);
        mTakePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
            }
        });
    }

    private void captureImage(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    private Uri getOutputMediaFileUri(int mediaTypeImage) {
        return Uri.fromFile(getOutputMediaFile());
    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "Offline");
        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                Log.d("Offline", "Oops! Failed create " + "Offline" + "directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
    }

    private void previewCapturedImage(){
        try{
            Bitmap bitmapOriginal = BitmapFactory.decodeFile(fileUri.getPath());
            BitmapFactory.Options options = new BitmapFactory.Options();
            original.setImageBitmap(bitmapOriginal);
            options.inSampleSize = 4;

            Bitmap bitmapTreated = BitmapFactory.decodeFile(fileUri.getPath(), options);
            treated.setImageBitmap(bitmapTreated);
            infoOriginal.setText("Width: " + bitmapOriginal.getWidth() + " px, Height: " + bitmapOriginal.getHeight() + " px");
            infoTreated.setText("Width: " + bitmapTreated.getWidth() + " px, Height: " + bitmapTreated.getHeight() + " px");
        }catch (NullPointerException e){

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK){
            switch(requestCode){
                case CAMERA_CAPTURE_IMAGE_REQUEST_CODE:
                    previewCapturedImage();
                    break;
                default:
                    super.onActivityResult(requestCode, resultCode, data);
            }
        }else {
            Toast.makeText(getApplicationContext(), "CANCEL", Toast.LENGTH_SHORT).show();
        }
    }
}
