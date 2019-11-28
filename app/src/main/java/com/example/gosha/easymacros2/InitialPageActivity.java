package com.example.gosha.easymacros2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InitialPageActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    int feet, inch, weight, age, height, bmr;

    EditText feetIn;
    EditText inchIn;
    EditText weightIn;
    EditText ageIn;
    Spinner genderIn;

    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_page);

        genderIn = findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderIn.setAdapter(adapter);
        genderIn.setOnItemSelectedListener(this);

        feetIn = findViewById(R.id.feetIn);
        inchIn =  findViewById(R.id.inchIn);
        weightIn =  findViewById(R.id.weightIn);
        ageIn =  findViewById(R.id.ageIn);
        calculate = findViewById(R.id.calculate);
        calculate.setEnabled(false);

        feetIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkRequiredFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inchIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkRequiredFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        weightIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkRequiredFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ageIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkRequiredFields();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmr();
                mainPage();
            }
        });


    }

    private void checkRequiredFields(){
        if(!feetIn.getText().toString().isEmpty() && !inchIn.getText().toString().isEmpty() && !weightIn.getText().toString().isEmpty() && !ageIn.getText().toString().isEmpty() && genderIn.getSelectedItem() != null){
            calculate.setEnabled(true);
        } else {
            calculate.setEnabled(false);
        }
    }

    private void calculateBmr() {
        feet = Integer.valueOf(feetIn.getText().toString());
        inch = Integer.valueOf(inchIn.getText().toString());
        weight = Integer.valueOf(weightIn.getText().toString());
        age = Integer.valueOf(ageIn.getText().toString());

        height = (feet * 12) + inch;
        if(genderIn.getSelectedItem().toString().equals("Male")) {
            bmr = (int) (66 + (6.23 * weight) + (12.7 * height) - (6.8 * age));
        } else {
            bmr = (int) (665 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
        }
    }

    public void mainPage(){
        Intent intent = new Intent(this, MainPage.class);
        intent.putExtra("bmr", bmr);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
