package com.example.calculator01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator(findViewById(R.id.totalDisplay));
    }

    public void pressButton(View v ) {
        Log.i("pressButton", v.getResources().getResourceName(v.getId()));
        switch (v.getId()) {
            // Check digit buttons
            case (R.id.button0):
                calculator.pressNumber(0);
                break;
            case (R.id.button1):
                calculator.pressNumber(1);
                break;
            case (R.id.button2):
                calculator.pressNumber(2);
                break;
            case (R.id.button3):
                calculator.pressNumber(3);
                break;
            case (R.id.button4):
                calculator.pressNumber(4);
                break;
            case (R.id.button5):
                calculator.pressNumber(5);
                break;
            case (R.id.button6):
                calculator.pressNumber(6);
                break;
            case (R.id.button7):
                calculator.pressNumber(7);
                break;
            case (R.id.button8):
                calculator.pressNumber(8);
                break;
            case (R.id.button9):
                calculator.pressNumber(9);
                break;

            // Check operator buttons
            case (R.id.buttonEquals):
                calculator.pressButton(Calculator.Button.EQUALS);
                break;
            case (R.id.buttonPlus):
                calculator.pressButton(Calculator.Button.PLUS);
                break;
            case (R.id.buttonMinus):
                calculator.pressButton(Calculator.Button.MINUS);
                break;
            case (R.id.buttonMultiply):
                calculator.pressButton(Calculator.Button.MULTIPLY);
                break;
            case (R.id.buttonDivide):
                calculator.pressButton(Calculator.Button.DIVIDE);
                break;
            case (R.id.buttonDot):
                calculator.pressButton(Calculator.Button.DOT);
                break;
            case (R.id.buttonAllClear):
                calculator.pressButton(Calculator.Button.ALL_CLEAR);
                break;
        }
    }
}