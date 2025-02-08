package com.kushal.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10,
            bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20,
            bt_sm1, bt_sm2, bt_sm3, bt_sm4, bt_sm5, bt_sm6,
            bt_2sm1, bt_2sm2, bt_2sm3, bt_2sm4, bt_2sm5, bt_2sm6,
            bt_3sm1, bt_3sm2, bt_3sm3, bt_3sm4, bt_3sm5, bt_3sm6;

    private String currentNumber = "";
    private String currentOperator = "";
    private double firstNumber = 0;
    private double secondNumber = 0;
    private boolean isOperatorClicked = false;
    private double memoryValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv1);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt10 = findViewById(R.id.bt10);
        bt11 = findViewById(R.id.bt11);
        bt12 = findViewById(R.id.bt12);
        bt13 = findViewById(R.id.bt13);
        bt14 = findViewById(R.id.bt14);
        bt15 = findViewById(R.id.bt15);
        bt16 = findViewById(R.id.bt16);
        bt17 = findViewById(R.id.bt17);
        bt18 = findViewById(R.id.bt18);
        bt19 = findViewById(R.id.bt19);
        bt20 = findViewById(R.id.bt20);

        //This is for the functional buttons
        bt_sm1 = findViewById(R.id.bt_sm1);
        bt_sm2 = findViewById(R.id.bt_sm2);
        bt_sm3 = findViewById(R.id.bt_sm3);
        bt_sm4 = findViewById(R.id.bt_sm4);
        bt_sm5 = findViewById(R.id.bt_sm5);
        bt_sm6 = findViewById(R.id.bt_sm6);
        bt_2sm1 = findViewById(R.id.bt_2sm1);
        bt_2sm2 = findViewById(R.id.bt_2sm2);
        bt_2sm3 = findViewById(R.id.bt_2sm3);
        bt_2sm4 = findViewById(R.id.bt_2sm4);
        bt_2sm5 = findViewById(R.id.bt_2sm5);
        bt_2sm6 = findViewById(R.id.bt_2sm6);
        bt_3sm1 = findViewById(R.id.bt_3sm1);
        bt_3sm2 = findViewById(R.id.bt_3sm2);
        bt_3sm3 = findViewById(R.id.bt_3sm3);
        bt_3sm4 = findViewById(R.id.bt_3sm4);
        bt_3sm5 = findViewById(R.id.bt_3sm5);
        bt_3sm6 = findViewById(R.id.bt_3sm6);
        setButtonListeners();
    }

    private void setButtonListeners() {
        bt5.setOnClickListener(v -> appendNumber("7"));
        bt6.setOnClickListener(v -> appendNumber("8"));
        bt7.setOnClickListener(v -> appendNumber("9"));
        bt9.setOnClickListener(v -> appendNumber("4"));
        bt10.setOnClickListener(v -> appendNumber("5"));
        bt11.setOnClickListener(v -> appendNumber("6"));
        bt13.setOnClickListener(v -> appendNumber("1"));
        bt14.setOnClickListener(v -> appendNumber("2"));
        bt15.setOnClickListener(v -> appendNumber("3"));
        bt18.setOnClickListener(v -> appendNumber("0"));
        bt19.setOnClickListener(v -> appendNumber("."));

        bt4.setOnClickListener(v -> setOperator("÷"));
        bt8.setOnClickListener(v -> setOperator("×"));
        bt12.setOnClickListener(v -> setOperator("−"));
        bt16.setOnClickListener(v -> setOperator("+"));
        bt1.setOnClickListener(v -> clear());
        bt20.setOnClickListener(v -> calculateResult());
        bt17.setOnClickListener(v -> backspace());
        bt2.setOnClickListener(v -> toggleSign());
        bt3.setOnClickListener(v -> calculatePercentage());
        bt_sm1.setOnClickListener(v -> memoryAdd()); // M+
        bt_sm2.setOnClickListener(v -> memorySubtract()); // M-
        bt_sm3.setOnClickListener(v -> memoryRecall()); // MR
        bt_sm4.setOnClickListener(v -> memoryClear()); // MC
        bt_sm5.setOnClickListener(v -> appendNumber("(")); // (
        bt_sm6.setOnClickListener(v -> appendNumber(")")); // )
        bt_2sm1.setOnClickListener(v -> calculatePercentage()); // %
        bt_2sm2.setOnClickListener(v -> powerFunction()); // x^y
        bt_2sm3.setOnClickListener(v -> appendNumber(String.valueOf(Math.PI))); // π
        bt_2sm4.setOnClickListener(v -> appendNumber(String.valueOf(Math.E))); // e
        bt_2sm5.setOnClickListener(v -> squareRoot()); // √
        bt_2sm6.setOnClickListener(v -> factorial()); // !
        bt_3sm1.setOnClickListener(v -> sinFunction()); // sin
        bt_3sm2.setOnClickListener(v -> cosFunction()); // cos
        bt_3sm3.setOnClickListener(v -> tanFunction()); // tan
        bt_3sm4.setOnClickListener(v -> toggleRadiansDegrees()); // Rad/Deg
        bt_3sm5.setOnClickListener(v -> appendNumber("°")); //
        bt_3sm6.setOnClickListener(v -> logFunction()); // log
    }

    private void appendNumber(String number) {
        if (isOperatorClicked) {
            currentNumber = "";
            isOperatorClicked = false;
        }
        currentNumber += number;
        tvResult.setText(currentNumber);
    }

    private void setOperator(String operator) {
        if (!currentNumber.isEmpty()) {
            firstNumber = Double.parseDouble(currentNumber);
            currentOperator = operator;
            isOperatorClicked = true;
        }
    }

    private void calculateResult() {
        if (!currentNumber.isEmpty() && !currentOperator.isEmpty()) {
            secondNumber = Double.parseDouble(currentNumber);
            double result = 0;

            switch (currentOperator) {
                case "÷":
                    result = firstNumber / secondNumber;
                    break;
                case "×":
                    result = firstNumber * secondNumber;
                    break;
                case "−":
                    result = firstNumber - secondNumber;
                    break;
                case "+":
                    result = firstNumber + secondNumber;
                    break;
            }

            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
            currentOperator = "";
            isOperatorClicked = true;
        }
    }

    private void clear() {
        currentNumber = "";
        currentOperator = "";
        firstNumber = 0;
        secondNumber = 0;
        isOperatorClicked = false;
        tvResult.setText("0");
    }

    private void backspace() {
        if (currentNumber.length() > 0) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            tvResult.setText(currentNumber);
        }
    }

    private void toggleSign() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            number *= -1;
            currentNumber = String.valueOf(number);
            tvResult.setText(currentNumber);
        }
    }

    private void calculatePercentage() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            number /= 100;
            currentNumber = String.valueOf(number);
            tvResult.setText(currentNumber);
        }
    }

    private void memoryAdd() {
        if (!currentNumber.isEmpty()) {
            memoryValue += Double.parseDouble(currentNumber);
        }
    }

    private void memorySubtract() {
        if (!currentNumber.isEmpty()) {
            memoryValue -= Double.parseDouble(currentNumber);
        }
    }

    private void memoryRecall() {
        currentNumber = String.valueOf(memoryValue);
        tvResult.setText(currentNumber);
    }

    private void memoryClear() {
        memoryValue = 0;
    }

    private void powerFunction() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            double result = Math.pow(firstNumber, number);
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    private void squareRoot() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            double result = Math.sqrt(number);
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    private void factorial() {
        if (!currentNumber.isEmpty()) {
            int number = Integer.parseInt(currentNumber);
            int result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    private void sinFunction() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            double result = Math.sin(Math.toRadians(number));
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    private void cosFunction() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            double result = Math.cos(Math.toRadians(number));
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    private void tanFunction() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            double result = Math.tan(Math.toRadians(number));
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }

    private void toggleRadiansDegrees() {

    }

    private void logFunction() {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            double result = Math.log10(number);
            tvResult.setText(String.valueOf(result));
            currentNumber = String.valueOf(result);
        }
    }
}