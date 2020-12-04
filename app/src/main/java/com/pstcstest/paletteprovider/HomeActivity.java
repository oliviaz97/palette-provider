package com.pstcstest.paletteprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private void startExtractColorsPhotoActivity(){
        Intent intent = new Intent(this, EditPhotoActivity.class);
        startActivity(intent);
    }

    private void startExtractColorsActivity(){
        Intent intent = new Intent(this, ExtractColorActivity.class);
        startActivity(intent);
    }
    private void startSavedColorsActivity(){
        Intent intent = new Intent(this, SavedColorsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button CameraRoll = (Button) findViewById(R.id.cameraRoll);
        Button ColorWheel = (Button) findViewById(R.id.colorWheel);
        Button SavedColors = (Button) findViewById(R.id.savedColors);
        CameraRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startExtractColorsPhotoActivity();
            }

        });
        ColorWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startExtractColorsActivity();
            }

        });

        SavedColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSavedColorsActivity();
            }

        });
    }
}