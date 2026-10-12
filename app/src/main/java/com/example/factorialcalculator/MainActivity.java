package com.example.factorialcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText number = findViewById(R.id.editTextNumber);
        TextView result = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button);

        result.setVisibility(View.INVISIBLE);
        button.setOnClickListener(view -> {
            // Errors and answers share this view, so it has to be visible for both.
            result.setVisibility(View.VISIBLE);
            result.setText(Factorial.calculate(number.getText().toString()));
        });
    }
}
