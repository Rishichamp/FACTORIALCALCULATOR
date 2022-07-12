package com.example.factorialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText editnum;
     TextView result;
     Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editnum=(EditText)findViewById(R.id.editTextNumber);
        result=(TextView) findViewById(R.id.textView2);
        btn=(Button) findViewById(R.id.button);
        result.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //NULL SAFETY
                if (editnum.getText().toString().isEmpty())
                {
                    result.setText("Number field can't be empty");
                }
                else
                {
                    String value = editnum.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    int r = fact(finalValue);
                    result.setText("Factorial=" + r);
                }
            }
    });
    }
    int fact(int n)
    {
        int i,f=1;
        for(i=1;i<=n;i++)
        {
            f=f*i;
        }
        result.setVisibility(View.VISIBLE);
        return f;
    }
}
