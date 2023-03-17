package com.example.calculator01;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Calculator {
    public enum Button{
        EQUALS,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        DOT,
        ALL_CLEAR
    }
    private final Display display;
    private String firstNumber;
    private String secondNumber;
    private Operand operand;
    private CalcState state;
    private enum CalcState{
        FIRST_NUMBER,
        SECOND_NUMBER,
        DONE
    }
    public Calculator(@NonNull TextView textViewDisplay){
        // set current state
        firstNumber = "0";
        secondNumber = "0";
        operand = new None();
        state = CalcState.FIRST_NUMBER;

        // create display obj
        this.display = new Display(textViewDisplay);
        display.setDisplay("0");
    }
    public void pressNumber(Integer digit) {
        if (state == CalcState.DONE){
            // resetting calculator
            firstNumber = "0";
            secondNumber = "0";
            display.setDisplay("0");
            state = CalcState.FIRST_NUMBER;
        }
        if (state == CalcState.FIRST_NUMBER) {
            if (Objects.equals(firstNumber, "0")) firstNumber = "";
            firstNumber += Integer.toString(digit);
            secondNumber = "0";
            display.setDisplay(firstNumber);
        } else if (state == CalcState.SECOND_NUMBER) {
            if (Objects.equals(secondNumber, "0")) secondNumber = "";
            secondNumber += Integer.toString(digit);
            display.setDisplay(secondNumber);
        }

    }
    public void pressButton(Button button) {
        if (button == Button.ALL_CLEAR) {
            firstNumber = "0";
            secondNumber = "0";
            state = CalcState.FIRST_NUMBER;
            display.setDisplay("0");
        } else if (button == Button.DOT) {
            if (state == CalcState.FIRST_NUMBER){
                if (firstNumber.contains(".")) return;
                firstNumber += ".";
                display.setDisplay(firstNumber);
            } else if (state == CalcState.SECOND_NUMBER){
                if (secondNumber.contains(".")) return;
                secondNumber += ".";
                display.setDisplay(secondNumber);
            }
        } else if (button == Button.EQUALS){
            Log.i("Equals", "State:"+state);
            if (state == CalcState.FIRST_NUMBER){
                secondNumber = firstNumber;
            }
            firstNumber = operand.compute(firstNumber, secondNumber);
            secondNumber = "0";
            state = CalcState.DONE;
            display.setDisplayFormatted(firstNumber);
        } else {
            state = CalcState.SECOND_NUMBER;
            if (button == Button.PLUS){
                operand = new Plus();
            } else if (button == Button.MINUS) {
                operand = new Minus();
            } else if (button == Button.MULTIPLY) {
                operand = new Multiply();
            } else if (button == Button.DIVIDE) {
                operand = new Divide();
            }
        }
    }
}
