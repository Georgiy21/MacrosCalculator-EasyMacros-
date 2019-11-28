package com.example.gosha.easymacros2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView prot_br, carb_br, fat_br, cal_br;
    TextView prot_lu, carb_lu, fat_lu, cal_lu;
    TextView daily_cal, cal_con;
    Button menu, menu1;

    int global_calories, calories_con, breakfast_protein = 0, breakfast_carbs = 0, breakfast_fats = 0, breakfast_cal = 0;
    int lunch_protein, lunch_carbs, lunch_fats, lunch_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        initialize();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        Intent intent = getIntent();
        int bmr = intent.getIntExtra("bmr",0);
        global_calories = (int) (bmr * 1.2);


        int proteinPB = intent.getIntExtra("ppBr",0);
        int proteinCB = intent.getIntExtra("pcBr",0);
        int proteinFB = intent.getIntExtra("pfBr",0);
        int proteinCkB = intent.getIntExtra("pckBr",0);

        int carbPB = intent.getIntExtra("cpBr",0);
        int carbCB = intent.getIntExtra("ccBr",0);
        int carbFB = intent.getIntExtra("cfBr",0);
        int carbCkB = intent.getIntExtra("cckBr",0);

        breakfast_protein = proteinPB + carbPB;
        breakfast_carbs = proteinCB + carbCB;
        breakfast_fats = proteinFB + carbFB;
        breakfast_cal = proteinCkB + carbCkB;
        calories_con = breakfast_cal + lunch_cal;


        daily_cal.setText(String.valueOf((global_calories)));
        cal_con.setText(String.valueOf(calories_con));
        prot_br.setText(String.valueOf(breakfast_protein));
        carb_br.setText(String.valueOf(breakfast_carbs));
        fat_br.setText(String.valueOf(breakfast_fats));
        cal_br.setText(String.valueOf(breakfast_cal));
    }

    private void openMenu(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
    public void initialize() {
        prot_br = findViewById(R.id.prot_br_output);
        carb_br = findViewById(R.id.carb_br_output);
        fat_br = findViewById(R.id.fat_br_output);
        cal_br = findViewById(R.id.cal_br_output);

        prot_lu = findViewById(R.id.prot_lu_output);
        carb_lu = findViewById(R.id.carb_lu_output);
        fat_lu = findViewById(R.id.fat_lu_output);
        cal_lu = findViewById(R.id.cal_lu_output);

        daily_cal = findViewById(R.id.daily_cal_output);
        cal_con = findViewById(R.id.cal_con_output);

        menu = findViewById(R.id.menu);
        menu1 = findViewById(R.id.menu1);
    }

}
