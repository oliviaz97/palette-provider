package com.pstcstest.paletteprovider;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
public class EditPhotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);
        ImageView imageView = findViewById(R.id.editPhotoImage);
        if(getIntent().hasExtra("bitmap")) {
            System.out.println("HERE");
            Bitmap b = (Bitmap) getIntent().getParcelableExtra("bitmap");
            imageView.setImageBitmap(b);
        }else{
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                int resId = bundle.getInt("resId");
                imageView.setImageResource(resId);
            }
        }

//        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("Image");
//        if (bitmap != null) {
//            imageView.setImageBitmap(bitmap);
//        }
//        else {
//
//        }
        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_edit_photo);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_edit_photo);
        Button ContinueButton = (Button) findViewById(R.id.continueButton);
        Button ZoomButton = (Button) findViewById(R.id.zoomButton);
        Button BrightnessButton = (Button) findViewById(R.id.brightnessButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        ContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditPhotoActivity.this, ExtractColorPhotoActivity.class);
                imageView.invalidate();
                //BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
             ////   Bitmap bitmap = bitmapDrawable.getBitmap();
                //intent.putExtra("Image", bitmap);
                startActivity(intent);
            }
        });
        ZoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startZoomActivity();
            }
        });
        BrightnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditPhotoActivity.this, BrightnessActivity.class);
//                imageView.invalidate();
//                imageView.buildDrawingCache();
                //Bitmap bitmap = imageView.getDrawingCache();
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
//                Bitmap bitmap = bitmapDrawable.getBitmap();
               // intent.putExtra("Image", bitmap);
                startActivity(intent);
            }
        });
    }
    private void startHomeScreenActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void startZoomActivity() {
        Intent intent = new Intent(this, ZoomActivity.class);
        startActivity(intent);
    }
}
//package com.pstcstest.paletteprovider;
//import androidx.appcompat.app.AppCompatActivity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//public class EditPhotoActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_photo);
//        ImageView imageView = findViewById(R.id.editPhotoImage);
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            int resId = bundle.getInt("resId");
//            imageView.setImageResource(resId);
//        }
//        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_edit_photo);
//        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_edit_photo);
//        Button ContinueButton = (Button) findViewById(R.id.continueButton);
//        Button ZoomButton = (Button) findViewById(R.id.zoomButton);
//        Button BrightnessButton = (Button) findViewById(R.id.brightnessButton);
//        HomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//        ContinueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startExtractColorPhotoActivity();
//            }
//        });
//        ZoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startZoomActivity();
//            }
//        });
//        BrightnessButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startBrightnessActivity();
//            }
//        });
//    }
//    private void startHomeScreenActivity() {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
//    private void startExtractColorPhotoActivity() {
//        Intent intent = new Intent(this, ExtractColorPhotoActivity.class);
//        startActivity(intent);
//    }
//    private void startZoomActivity() {
//        Intent intent = new Intent(this, ZoomActivity.class);
//        startActivity(intent);
//    }
//    private void startBrightnessActivity() {
//        Intent intent = new Intent(this, BrightnessActivity.class);
//        startActivity(intent);
//    }
//}
//

//package com.pstcstest.paletteprovider;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//
//public class EditPhotoActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_photo);
//
//        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_edit_photo);
//        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_edit_photo);
//        Button ContinueButton = (Button) findViewById(R.id.continueButton);
//        Button ZoomButton = (Button) findViewById(R.id.zoomButton);
//        Button BrightnessButton = (Button) findViewById(R.id.brightnessButton);
//        HomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//        ContinueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startExtractColorPhotoActivity();
//            }
//
//
//        });
//        ZoomButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startZoomActivity();
//            }
//        });
//        BrightnessButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startBrightnessActivity();
//            }
//        });
//    }
//    private void startHomeScreenActivity() {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
//    private void startExtractColorPhotoActivity() {
//        Intent intent = new Intent(this, ExtractColorPhotoActivity.class);
//        startActivity(intent);
//    }
//    private void startZoomActivity() {
//        Intent intent = new Intent(this, ZoomActivity.class);
//        startActivity(intent);
//
//    }
//    private void startBrightnessActivity() {
//        Intent intent = new Intent(this, BrightnessActivity.class);
//        startActivity(intent);
//
//    }
//}