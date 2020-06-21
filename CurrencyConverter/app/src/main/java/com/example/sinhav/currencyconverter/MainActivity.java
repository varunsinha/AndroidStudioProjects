package com.example.sinhav.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View View){
        EditText amount = (EditText) findViewById(R.id.amountEditText);
        double amount_double = Double.parseDouble(amount.getText().toString());
        double dollar = amount_double*1.3;
        Toast.makeText(this, "Converted Value = "+Double.toString(dollar), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
