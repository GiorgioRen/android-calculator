package com.example.calculator01;

import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.Locale;

public class Display {

    private final TextView display;
    protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
    protected AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;

    public Display(@NonNull TextView display){
        this.display = display;
        Log.i("Display", "Created new display obj");
    }
    public void setDisplay(CharSequence number){
        display.setText(String.format(Locale.getDefault(), (String) number));
        Log.i("Display","Set display to "+number);
    }
    public void setDisplayFormatted(CharSequence number){
        // quick fade out and fade in if result is the same number as the secondNumber (like 12-6=6)
        if (String.format((String) number).replaceAll("\\.0+$", "").equals((String) display.getText())) {
            display.startAnimation(fadeOut);
            display.startAnimation(fadeIn);
            fadeIn.setDuration(100);
            fadeIn.setFillAfter(true);
            fadeOut.setDuration(100);
            fadeOut.setFillAfter(true);
            fadeOut.setStartOffset(fadeIn.getStartOffset());
        }
        // very fancy
        display.setText(String.format(Locale.getDefault(), (String) number).replaceAll("\\.0+$", ""));
        Log.i("Display","Set display formatted to "+number+" removing trailing zeros");
    }
}
