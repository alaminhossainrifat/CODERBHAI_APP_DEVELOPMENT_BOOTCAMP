package com.codervai.calculator;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codervai.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    NumberFormat numberFormat = new DecimalFormat("#.########");

    double storedValue = 0.0;
    String operator = "";
    String currentValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpListener();
    }

    private void setUpListener() {
        List.of(
                binding.zero, binding.one, binding.two, binding.three,
                binding.four, binding.five, binding.six, binding.seven,
                binding.eight, binding.nine, binding.dot
        ).forEach(view -> view.setOnClickListener(this::digitClicked));

        List.of(
                binding.add, binding.subtract, binding.multiply, binding.divide
        ).forEach(view -> view.setOnClickListener(this::operationClicked));

        binding.equal.setOnClickListener(v -> {
            if (!currentValue.isEmpty() && !operator.isEmpty()) {
                storedValue = calculate();
                operator = "";
                currentValue = "";
                showScreen();
            }
        });

        binding.allClear.setOnClickListener(v -> {
            storedValue = 0.0;
            operator = "";
            currentValue = "0";
            showScreen();
        });

        binding.clear.setOnClickListener(v -> {
            currentValue = "0";
            showScreen();
        });
    }

    private void operationClicked(View view) {
        String operator = view.getTag().toString();
        if (this.operator.isEmpty()) {
            storedValue = Double.parseDouble(currentValue);
        } else {
            storedValue = calculate();
        }

        currentValue = "0";
        this.operator = operator;
        showScreen();
    }

    private double calculate() {
        double result = storedValue;
        double currentValue = Double.parseDouble(this.currentValue);

        switch (operator) {
            case "+":
                result += currentValue;
                break;
            case "-":
                result -= currentValue;
                break;
            case "*":
                result *= currentValue;
                break;
            case "/":
                result /= currentValue;
                break;
        }

        return result;
    }

    private void digitClicked(View view) {
        String digit = view.getTag().toString();
        String currentText = currentValue + digit;
        currentValue = currentText.startsWith("0") && currentText.length() != 1 ?
                currentText.substring(1) : currentText;
        showScreen();
    }

    private void showScreen() {
        binding.screen.setText(
                String.format("%s%s",
                        !operator.isEmpty() ?
                                (numberFormat.format(storedValue) + " " + operator + "\n") :
                                (storedValue != 0 ? String.format("%s\n", numberFormat.format(storedValue)) : ""),
                        currentValue)
        );
    }
}