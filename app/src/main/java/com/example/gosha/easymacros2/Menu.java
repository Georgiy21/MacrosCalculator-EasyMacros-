package com.example.gosha.easymacros2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class Menu extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i  < mainGrid.getChildCount(); i++) {
            CardView cardView1 = (CardView) mainGrid.getChildAt(i);
            final int finali = i;
            cardView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finali == 0){
                        Intent intent = new Intent(Menu.this, proteinIntent.class);
                        startActivity(intent);
                    } else if (finali == 1){
                        Intent intent = new Intent(Menu.this, carbIntent.class);
                        startActivity(intent);
                    } else if (finali == 2){
                        Intent intent = new Intent(Menu.this, fatIntent.class);
                        startActivity(intent);
                    } else if (finali == 3){
                        Intent intent = new Intent(Menu.this, vegIntent.class);
                        startActivity(intent);
                    }

                    //Toast.makeText(Menu.this, "Clicked at index " + finali, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
