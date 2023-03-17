package com.example.calculator01;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.Locale;

public class Display {

    private final TextView display;
    private final DecimalFormat format = new DecimalFormat("0.#");

    public Display(@NonNull TextView display){
        this.display = display;
        Log.i("Display", "Created new display obj");
    }
    public void setDisplay(CharSequence number){
        //display.setText(String.format(Locale.getDefault(), format.format(Double.parseDouble((String) number)) ) );
        display.setText(String.format(Locale.getDefault(), (String) number));
        Log.i("Display","Set display to "+number);
    }
    public void setDisplayFormatted(CharSequence number){
        // very fancy
        display.setText(String.format(Locale.getDefault(), (String) number).replaceAll("\\.0+$", ""));
        Log.i("Display","Set display formatted to "+number+" removing trailing zeros");
    }
}
