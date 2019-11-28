package com.example.gosha.easymacros2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import static java.util.logging.Logger.global;

public class proteinIntent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button confirm;
    Spinner portion;
    ImageView image_top, image_bottom;

    //int[] IMAGEID = {R.drawable.chicken_breast, R.drawable.angus_beef};

    int total_prot = 0, total_carb = 0, total_fat = 0, total_cal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_intent);

        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        image_top = findViewById(R.id.imageTop);
        image_bottom = findViewById(R.id.imageSide);

        portion = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> portion_adapter = ArrayAdapter.createFromResource(this, R.array.portion, android.R.layout.simple_spinner_item);
        portion_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        portion.setAdapter(portion_adapter);
        portion.setOnItemSelectedListener(this);
        portion.setVisibility(View.INVISIBLE);

        String[] FOODITEMS = {"Chicken Breast", "Angus Beef"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FOODITEMS);
        ListView foodList = findViewById(R.id.foodList);
        foodList.setAdapter(adapter);

        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String act = String.valueOf(parent.getItemAtPosition(position));
                switch (act) {
                    case "Chicken Breast":
                        portion.setVisibility(View.VISIBLE);
                        if (portion.getSelectedItem().equals("1/3")) {
                            //50 gr
                            image_top.setImageResource(R.drawable.chicken13);
                            image_bottom.setImageResource(R.drawable.side_chicken13);
                            total_prot = total_prot + (total_prot + 16);
                            total_carb = 0;
                            total_fat = total_fat + (total_fat + 1);
                            total_cal = total_cal + (total_cal + 82);
                            confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openMainPage();
                                }
                            });
                        } else if (portion.getSelectedItem().equals("2/3")) {
                            //100 gr
                            image_top.setImageResource(R.drawable.chicken23);
                            image_bottom.setImageResource(R.drawable.side_chicken23);
                            total_prot = total_prot + (total_prot + 23);
                            total_carb = 0;
                            total_fat = total_fat + (total_fat + 1);
                            total_cal = total_cal + (total_cal + 110);
                            confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openMainPage();
                                }
                            });
                        } else {
                            //150 gr
                            image_top.setImageResource(R.drawable.chicken33);
                            image_bottom.setImageResource(R.drawable.side_chicken33);
                            total_prot = total_prot + (total_prot + 35);
                            total_carb = 0;
                            total_fat = total_fat + (total_fat + 2);
                            total_cal = total_cal + (total_cal + 165);
                            confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openMainPage();
                                }
                            });
                        }
                        break;
                    case "Angus Beef":
                        break;
                }
            }
        });

    }

    private void openMainPage(){
        Intent intent = new Intent(this, MainPage.class);
        intent.putExtra("ppBr", total_prot);
        intent.putExtra("pcBr", total_carb);
        intent.putExtra("pfBr", total_fat);
        intent.putExtra("pckBr", total_cal);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    /*class CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return IMAGEID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView image = convertView.findViewById(R.id.foodImage);
            TextView text = convertView.findViewById(R.id.name);

            image.setImageResource(IMAGEID[position]);
            text.setText(FOODITEMS[position]);

            return convertView;
        }
    }*/
}
