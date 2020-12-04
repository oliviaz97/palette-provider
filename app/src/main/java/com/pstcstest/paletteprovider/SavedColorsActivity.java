package com.pstcstest.paletteprovider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class SavedColorsActivity extends AppCompatActivity {
    final Map<Integer, HashMap<Integer, PaletteColor>> POSSIBLE_COLORS = new HashMap<>();

    private void createPossibleColors(){

        HashMap<Integer, PaletteColor> lightGrey = new HashMap<>();

        lightGrey.put(Color.rgb(255, 255, 255), new PaletteColor(80, "White"));
        lightGrey.put(Color.rgb(0, 0, 0), new PaletteColor(20, "Black"));
        POSSIBLE_COLORS.put(Color.rgb(200, 200, 200), lightGrey);

        HashMap<Integer, PaletteColor> darkGrey = new HashMap<>();
        darkGrey.put(Color.rgb(255, 255, 255), new PaletteColor(20, "White"));
        darkGrey.put(Color.rgb(0, 0, 0), new PaletteColor(80, "Black"));
        POSSIBLE_COLORS.put(2631720, darkGrey);

        HashMap<Integer, PaletteColor> darkBlue = new HashMap<>();
        darkBlue.put(Color.rgb(0, 0, 255), new PaletteColor(70, "True Blue"));
        darkBlue.put(Color.rgb(0, 0, 0), new PaletteColor(15, "Black"));
        darkBlue.put(Color.rgb(255, 158, 0), new PaletteColor(15, "Bright Orange"));
        POSSIBLE_COLORS.put(Color.rgb(0, 0, 185), darkBlue);

        HashMap<Integer, PaletteColor> purple = new HashMap<>();
        purple.put(Color.rgb(158, 0, 0),  new PaletteColor(45, "Santa Red"));
        purple.put(Color.rgb(0, 0, 255), new PaletteColor(45, "True Blue"));
        purple.put(Color.rgb(0, 55, 255),  new PaletteColor(10, "Ocean Blue"));
        POSSIBLE_COLORS.put(Color.rgb(160, 0, 158), purple);

        HashMap<Integer, PaletteColor> pink = new HashMap<>();
        pink.put(Color.rgb(0, 0, 158),  new PaletteColor(45, "Primary Blue"));
        pink.put(Color.rgb(255, 0, 0),  new PaletteColor(45, "True Red"));
        pink.put(Color.rgb(0, 155, 0),  new PaletteColor(10, "Avocado"));
        POSSIBLE_COLORS.put(Color.rgb(255, 155, 158), pink);

        HashMap<Integer, PaletteColor> orange = new HashMap<>();
        orange.put(Color.rgb(255, 0, 0),  new PaletteColor(70, "True Red"));
        orange.put(Color.rgb(0, 145, 0),  new PaletteColor(25, "Avocado"));
        orange.put(Color.rgb(0, 0, 150),  new PaletteColor(5, "Primary Blue"));
        POSSIBLE_COLORS.put(Color.rgb(255, 145, 54), orange);

        HashMap<Integer, PaletteColor> teal = new HashMap<>();
        teal.put(Color.rgb(0, 255, 0), new PaletteColor(70, "Festive Green"));
        teal.put(Color.rgb(0, 0, 193), new PaletteColor(25, "True Blue"));
        teal.put(Color.rgb(222, 222, 222), new PaletteColor(5, "Slate"));
        POSSIBLE_COLORS.put(Color.rgb(15, 255, 193), teal);


        HashMap<Integer, PaletteColor> darkRed = new HashMap<>();

        darkRed.put(Color.rgb(255, 0, 0),  new PaletteColor(70, "True Red"));
        darkRed.put(Color.rgb(0, 55, 255),  new PaletteColor(20, "Ocean Blue"));
        darkRed.put(Color.rgb(0, 0, 0), new PaletteColor(10, "Black"));
        POSSIBLE_COLORS.put(Color.rgb(131, 52, 52), darkRed);

        HashMap<Integer, PaletteColor> lightBlue = new HashMap<>();

        lightBlue.put(Color.rgb(0, 0, 255), new PaletteColor(70, "True Blue"));
        lightBlue.put(Color.rgb(255, 255, 255), new PaletteColor(20, "White"));
        lightBlue.put(Color.rgb(0, 255, 0), new PaletteColor(10, "Festive Green"));
        POSSIBLE_COLORS.put(Color.rgb(0xa2, 0xd7, 0xdd), lightBlue);

        HashMap<Integer, PaletteColor> lightGreen = new HashMap<>();

        lightGreen.put(Color.rgb(255, 255, 255), new PaletteColor(80, "White"));
        lightGreen.put(Color.rgb(0, 255, 0), new PaletteColor(20, "Festive Green"));
        POSSIBLE_COLORS.put(Color.rgb(0xf1, 0xff, 0xed), lightGreen);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_colors);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        Set<String> savedColors = sharedPreferences.getStringSet(getString(R.string.saved_colors_key), new HashSet<>());
        System.out.println("SAVED COLORS");
        System.out.println(savedColors.toString());

        LinearLayout savedColorsLayout = (LinearLayout) findViewById(R.id.savedColorsLayout);
        int count = 0;
        LinearLayout savedColorsRow = new LinearLayout(this);
        for(String savedColor : savedColors){
            if(count % 4 == 0){
                savedColorsLayout.addView(savedColorsRow);
                savedColorsRow = new LinearLayout(this);
                savedColorsRow.setOrientation(LinearLayout.HORIZONTAL);
                savedColorsRow.setPadding(0, 0, 0, 80);
            }
            View colorSquare = createColorSquareView(Integer.parseInt(savedColor));
            savedColorsRow.addView(colorSquare);

            count += 1;
        }
        savedColorsLayout.addView(savedColorsRow);
        savedColorsLayout.invalidate();

        createPossibleColors();

        View pc0 = (View) findViewById(R.id.popColor00);
        pc0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startResultsActivity(Color.rgb(0xa2, 0xd7, 0xdd));
            }
        });

        View pc1 =(View) findViewById(R.id.popColor01);
        pc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startResultsActivity(Color.rgb(0xf1, 0xff, 0xed));
            }
        });

        View pc2 = (View) findViewById(R.id.popColor02);
        pc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startResultsActivity(Color.rgb(0xff, 0xa7, 0xa3));
            }
        });

        ImageButton HomeSC = (ImageButton) findViewById(R.id.homebutton_sc_photo);
        ImageButton BackSC = (ImageButton) findViewById(R.id.backbutton_sc_photo);
        HomeSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("RAN");
                startResultsActivity(Color.rgb(0xff, 0xa7, 0xa3));

//                startHomeScreenActivity();
            }
        });
        BackSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("RAN");
                startResultsActivity(Color.rgb(0xff, 0xa7, 0xa3));
//                startHomeScreenActivity();
            }
        });
    }
    TextView createColorSquareView(int color){
        TextView colorSquareView = new TextView(this);
        colorSquareView.setBackground(ContextCompat.getDrawable(this, R.drawable.color_square));
        GradientDrawable gradientDrawable = (GradientDrawable) colorSquareView.getBackground().mutate();
        gradientDrawable.setColor(color);
//        int red = Color.red(color);
//        int green = Color.green(color);
//        int blue = Color.blue(color);

//        if((red*0.299 + green*0.587 + blue*0.114) > 145) {
//            colorSquareView.setTextColor(Color.BLACK);
//        }else {
//            colorSquareView.setTextColor(Color.WHITE);
//        }

        colorSquareView.setTextSize(24);
        colorSquareView.setGravity(Gravity.CENTER);
//        colorSquareView.setText(text);
//
        RelativeLayout.LayoutParams colorSquareLayoutParams = new RelativeLayout.LayoutParams(164, 164);
        colorSquareLayoutParams.setMargins(40, 0, 40, 0);
        colorSquareView.setLayoutParams(colorSquareLayoutParams);
        colorSquareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startResultsActivity(color);
            }
        });
        return colorSquareView;
    }

    private HashMap<Integer, PaletteColor> divideSelectedColor(int targetColor){
        int targetGreen = Color.green(targetColor);
        int targetRed = Color.red(targetColor);
        int targetBlue = Color.blue(targetColor);

        Integer bestApproxColor = -1;
        Integer smallestDiff = Integer.MAX_VALUE;
        for(Integer color : POSSIBLE_COLORS.keySet()){
            int green = Color.green(color);
            int red = Color.red(color);
            int blue = Color.blue(color);
            int diff = Math.abs(targetBlue-blue) + Math.abs(targetRed-red) +Math.abs(targetGreen-green);
            if(diff < smallestDiff){
                smallestDiff = diff;
                bestApproxColor = color;
            }
        }
        if(bestApproxColor == -1){
            System.out.println("HERE");
            return POSSIBLE_COLORS.get(Color.rgb(200, 200, 200));
        }

        return POSSIBLE_COLORS.get(bestApproxColor);
    }

    private void startResultsActivity(int targetColor){
        System.out.println("RAN");
        Intent intent = new Intent(this, ResultsActivity.class);

        HashMap<Integer, PaletteColor> dividedColors = divideSelectedColor(targetColor);

        System.out.println(dividedColors);
        intent.putExtra(getString(R.string.target_color_key), targetColor);
        intent.putExtra(getString(R.string.divided_colors_key), dividedColors);
        startActivity(intent);
    }

    private void startHomeScreenActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}