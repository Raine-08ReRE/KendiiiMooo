package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonDiff, buttonProd, buttonQuo;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btnAdd);
        buttonDiff = findViewById(R.id.btnDiff);
        buttonProd = findViewById(R.id.btnProd);
        buttonQuo = findViewById(R.id.btnQuo);
        editTextN1 = findViewById(R.id.etFirstNumber);
        editTextN2 = findViewById(R.id.etSecondNumber);
        textView = findViewById(R.id.tvResult);

        buttonAdd.setOnClickListener(this);
        buttonDiff.setOnClickListener(this);
        buttonProd.setOnClickListener(this);
        buttonQuo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        int viewId = v.getId();

        if (viewId == R.id.btnAdd) {
            float sum = num1 + num2;
            textView.setText("Total SUM is: " + sum);
            setTextColorBasedOnResult(sum);
        } else if (viewId == R.id.btnDiff) {
            float diff = num1 - num2;
            textView.setText("Total DIFF is: " + diff);
            setTextColorBasedOnResult(diff);
        } else if (viewId == R.id.btnProd) {
            float prod = num1 * num2;
            textView.setText("Total PROD is: " + prod);
            setTextColorBasedOnResult(prod);
        } else if (viewId == R.id.btnQuo) {
            if (num2 != 0) {
                float quo = (float) num1 / num2;
                textView.setText("Total QUO is: " + quo);
                setTextColorBasedOnResult(quo);
            } else {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setTextColorBasedOnResult(float result) {
        if ((int) result % 2 == 0) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        } else {
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    public int getIntFromEditText(EditText editText) {
        String str = editText.getText().toString();
        if (str.isEmpty()) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(str);
    }
}