package com.pstcstest.paletteprovider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class ResultsActivity extends AppCompatActivity {

    private LinearLayout colorBreakdownLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        View decorView = getWindow().getDecorView();

        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        Intent intent = getIntent();
        HashMap<Integer, PaletteColor> dividedColors = (HashMap<Integer, PaletteColor>)intent.getSerializableExtra(getString(R.string.divided_colors_key));

        int targetColor = intent.getIntExtra(getString(R.string.target_color_key), 0);

        colorBreakdownLayout = (LinearLayout) findViewById(R.id.colorBreakdownLayout);

        RelativeLayout.LayoutParams colorRowLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        colorRowLayoutParams.setMargins(screenWidth / 8, 50, screenWidth / 8, 32);
        colorRowLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams colorSquareLayoutParams = new RelativeLayout.LayoutParams(164, 164);
        colorSquareLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        colorSquareLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        RelativeLayout.LayoutParams colorSquareTargetLayoutParams = new RelativeLayout.LayoutParams(300, 300);
        colorSquareTargetLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        colorSquareTargetLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams targetColorTextLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        targetColorTextLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        targetColorTextLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout targetColorRow = new RelativeLayout(this);
        targetColorRow.setLayoutParams(colorRowLayoutParams);
        targetColorRow.setGravity(Gravity.CENTER_VERTICAL);

        RelativeLayout targetColorRowText = new RelativeLayout(this);
        targetColorRowText.setLayoutParams(colorRowLayoutParams);
        targetColorRowText.setGravity(Gravity.CENTER_VERTICAL);
        targetColorRowText.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView targetColorSquareView = createColorSquareView(targetColor, "", colorSquareTargetLayoutParams);

        targetColorSquareView.setLayoutParams(colorSquareTargetLayoutParams);

        TextView targetColorTextView = createTargetColorTextView(getString(R.string.target_color), targetColorTextLayoutParams);

        targetColorRow.addView(targetColorSquareView);
        targetColorRowText.addView(targetColorTextView);

        colorBreakdownLayout.addView(targetColorRowText);
        colorBreakdownLayout.addView(targetColorRow);

        char colorIndex = 'A';
        Set<Integer> splitColors = dividedColors.keySet();
        List<Integer> orderedSplitColors = new ArrayList<>();
        List<Integer> orderedSplitPercentages = new ArrayList<>();

        int count = 0;
        for(Integer color : splitColors){
            if(count == 0){
                orderedSplitColors.add(color);
                orderedSplitPercentages.add(dividedColors.get(color).colorPercent);
            }else if(count == 1){
                if(orderedSplitPercentages.get(0) > dividedColors.get(color).colorPercent){
                    orderedSplitColors.add(color);
                    orderedSplitPercentages.add(dividedColors.get(color).colorPercent);
                }else{
                    orderedSplitColors.add(0, color);
                    orderedSplitPercentages.add(0, dividedColors.get(color).colorPercent);
                }
            }else if(count == 2){
                if(orderedSplitPercentages.get(1) > dividedColors.get(color).colorPercent) {
                    orderedSplitColors.add(color);
                    orderedSplitPercentages.add(dividedColors.get(color).colorPercent);
                }else if(orderedSplitPercentages.get(0) > dividedColors.get(color).colorPercent){
                    orderedSplitColors.add(1, color);
                    orderedSplitPercentages.add(1, dividedColors.get(color).colorPercent);
                }else{
                    orderedSplitColors.add(0, color);
                    orderedSplitPercentages.add(0, dividedColors.get(color).colorPercent);
                }
            }
            count += 1;
        }
        for(int i = 0; i < orderedSplitPercentages.size(); i++){
            int color = orderedSplitColors.get(i);

            String colorPercentage = dividedColors.get(color).colorPercent+"%";
            String colorString = dividedColors.get(color).colorName;

            RelativeLayout colorRow = new RelativeLayout(this);

            colorRow.setLayoutParams(colorRowLayoutParams);
            colorRow.setGravity(Gravity.CENTER_VERTICAL);

            TextView colorSquareView = createColorSquareView(color, colorPercentage, colorSquareLayoutParams);
            TextView colorTextView = createColorTextView(colorString);

            colorRow.addView(colorSquareView);
            colorRow.addView(colorTextView);

            colorBreakdownLayout.addView(colorRow);

            colorIndex += 1;
        }

        colorBreakdownLayout.invalidate();

        ImageButton HomeButton = (ImageButton) findViewById(R.id.home_results);
        ImageButton BackToExtractButton = (ImageButton) findViewById(R.id.back_results);

        Button saveThisColorButton = (Button) findViewById(R.id.saveThisColorButton);
        saveThisColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Set<String> savedColors = sharedPreferences.getStringSet(getString(R.string.saved_colors_key), new HashSet<>());

                savedColors.add(String.valueOf(targetColor));
                editor.putStringSet(getString(R.string.saved_colors_key), savedColors);
                editor.apply();
                startHomeActivity();
            }
        });

        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHomeActivity();
            }
        });
        BackToExtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void startHomeActivity(){

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    private void startExtractColorActivity(){

        Intent intent = new Intent(this, ExtractColorActivity.class);
        startActivity(intent);
    }
    TextView createTargetColorTextView(String text, RelativeLayout.LayoutParams lp){
        TextView colorTextView = new TextView(this);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.lobster2);
        colorTextView.setTypeface(typeface);
        colorTextView.setTextSize(40);
        colorTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_text));
        colorTextView.setText(text);
        colorTextView.setLayoutParams(lp);
        return colorTextView;
    }

    TextView createColorTextView(String text){
        TextView colorTextView = new TextView(this);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.lato_medium);
        colorTextView.setTypeface(typeface);
        colorTextView.setTextSize(36);
        colorTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_text));
        colorTextView.setText(text);
        colorTextView.setLayoutParams(lp);
        return colorTextView;
    }
    TextView createColorTextViewSquares(String text, RelativeLayout.LayoutParams lp){
        TextView colorTextView = new TextView(this);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.lato_medium);
        colorTextView.setTypeface(typeface);
        colorTextView.setTextSize(30);
        colorTextView.setTextColor(ContextCompat.getColor(this, R.color.theme_text));
        colorTextView.setText(text);
        colorTextView.setLayoutParams(lp);
        return colorTextView;
    }
    TextView createColorSquareView(int color, String text, RelativeLayout.LayoutParams lp){
        TextView colorSquareView = new TextView(this);
        colorSquareView.setBackground(ContextCompat.getDrawable(this, R.drawable.color_square));
        GradientDrawable gradientDrawable = (GradientDrawable) colorSquareView.getBackground().mutate();
        gradientDrawable.setColor(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        if((red*0.299 + green*0.587 + blue*0.114) > 145) {
            colorSquareView.setTextColor(Color.BLACK);
        }else {
            colorSquareView.setTextColor(Color.WHITE);
        }

        colorSquareView.setTextSize(24);
        colorSquareView.setGravity(Gravity.CENTER);
        colorSquareView.setText(text);

        colorSquareView.setLayoutParams(lp);
        return colorSquareView;
    }
}