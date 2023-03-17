package com.example.calculator01;

interface Operand {
    String compute(String firstNumber, String secondNumber);
}

class None implements Operand {
    protected Double n1, n2;
    None(){
        n1 = 0.0;
        n2 = 0.0;
    }
    protected void gimme(String firstNumber, String secondNumber){
        // dunno what i'm doing but it works
        n1 = Double.parseDouble(firstNumber);
        n2 = Double.parseDouble(secondNumber);
    }
    /**
     * This is called only when no operand has yet been chosen and the 'equals' button is pressed
     * This should only happen when we are expecting the firstNumber and no other operand button
     * has been pressed.
     * Since the equals routine assign the return value to firstNumber and sets secondNumber to zero
     * this *fake* method should just return the firstNumber.
     * @return firstNumber
     */
    public String compute(String firstNumber, String secondNumber){
        gimme(firstNumber, secondNumber);
        return firstNumber;
    }
}

class Plus extends None {
    @Override
    public String compute(String firstNumber, String secondNumber){
        gimme(firstNumber, secondNumber);
        return Double.toString(n1 + n2);
    }
}

class Minus extends None {
    public String compute(String firstNumber, String secondNumber){
        gimme(firstNumber, secondNumber);
        return Double.toString(n1 - n2);
    }
}


class Multiply extends None {
    public String compute(String firstNumber, String secondNumber){
        gimme(firstNumber, secondNumber);
        return Double.toString(n1 * n2);
    }
}

class Divide extends None {
    public String compute(String firstNumber, String secondNumber){
        gimme(firstNumber, secondNumber);
        return Double.toString(n1 / n2);
    }
}
