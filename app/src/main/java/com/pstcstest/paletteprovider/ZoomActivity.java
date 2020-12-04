package com.pstcstest.paletteprovider;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.pstcstest.paletteprovider.R;
public class ZoomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_zoom_photo);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_zoom_photo);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeScreenActivity();
            }
        });
        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEditPhotoActivity();
            }
        });
        ImageButton pic1 = (ImageButton) findViewById(R.id.Button01);
        ImageButton pic2 = (ImageButton) findViewById(R.id.Button02);
        ImageButton pic3 = (ImageButton) findViewById(R.id.Button03);
        ImageButton pic4 = (ImageButton) findViewById(R.id.Button04);
        ImageButton pic5 = (ImageButton) findViewById(R.id.Button05);
        ImageButton pic6 = (ImageButton) findViewById(R.id.Button06);
        ImageButton pic7 = (ImageButton) findViewById(R.id.Button07);
        ImageButton pic8 = (ImageButton) findViewById(R.id.Button08);
        ImageButton pic9 = (ImageButton) findViewById(R.id.Button09);
        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_001);
                startActivity(intent);
            }
        });
        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_002);
                startActivity(intent);
            }
        });
        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_003);
                startActivity(intent);
            }
        });
        pic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_004);
                startActivity(intent);
            }
        });
        pic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_005);
                startActivity(intent);
            }
        });
        pic6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_006);
                startActivity(intent);
            }
        });
        pic7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_007);
                startActivity(intent);
            }
        });
        pic8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_008);
                startActivity(intent);
            }
        });
        pic9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZoomActivity.this, EditPhotoActivity.class);
                intent.putExtra("resId", R.drawable.image_part_009);
                startActivity(intent);
            }
        });
    }
    private void startHomeScreenActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void startEditPhotoActivity() {
        Intent intent = new Intent(this, EditPhotoActivity.class);
        startActivity(intent);
    }
}

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
//import com.pstcstest.paletteprovider.R;
//
//public class ZoomActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_crop);
//        ImageButton HomeButton = (ImageButton) findViewById(R.id.homebutton_zoom_photo);
//        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.backbutton_zoom_photo);
//        HomeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startHomeScreenActivity();
//            }
//        });
//        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startEditPhotoActivity();
//            }
//        });
//
//    }
//    private void startHomeScreenActivity() {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
//    private void startEditPhotoActivity() {
//        Intent intent = new Intent(this, EditPhotoActivity.class);
//        startActivity(intent);
//    }
//}