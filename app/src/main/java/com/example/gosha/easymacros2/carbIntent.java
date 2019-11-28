package com.example.gosha.easymacros2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class carbIntent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button confirm;
    Spinner portion;
    ImageView image_top, image_bottom;

    int total_prot = 0, total_carb = 0, total_fat = 0, total_cal = 0;


    //int[] imageid = {R.drawable.rice_jasmine, R.drawable.potato};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carb_intent);

        image_top = findViewById(R.id.imageTop);
        image_bottom = findViewById(R.id.imageSide);

        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainPage();
            }
        });

        //CustomAdapter customAdapter = new CustomAdapter();
        //foodList.setAdapter(customAdapter);
        portion = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> portion_adapter = ArrayAdapter.createFromResource(this, R.array.portion, android.R.layout.simple_spinner_item);
        portion_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        portion.setAdapter(portion_adapter);
        portion.setOnItemSelectedListener(this);
        portion.setVisibility(View.INVISIBLE);

        String[] foodItems = {"Rice Jasmine", "Quick Oats"};
        ListView foodList = findViewById(R.id.foodList);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodItems);
        foodList.setAdapter(adapter);
        foodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String act = String.valueOf(parent.getItemAtPosition(position));
                switch (act) {
                    case "Rice Jasmine":
                        portion.setVisibility(View.VISIBLE);
                        if (portion.getSelectedItem().equals("1/3")) {
                            //50 gr
                            image_top.setImageResource(R.drawable.rice13);
                            image_bottom.setImageResource(R.drawable.side_rice13);
                            total_prot = total_prot + (total_prot + 3);
                            total_carb = total_carb + (total_carb + 38);
                            total_fat = total_fat + (total_fat + 1);
                            total_cal = total_cal + (total_cal + 173);
                            confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openMainPage();
                                }
                            });
                        } else if (portion.getSelectedItem().equals("2/3")){
                            //100 gr
                            image_top.setImageResource(R.drawable.rice23);
                            image_bottom.setImageResource(R.drawable.side_rice23);
                            total_prot = total_prot + (total_prot + 7);
                            total_carb = total_carb + (total_carb + 77);
                            total_fat = total_fat + (total_fat + 1);
                            total_cal = total_cal + (total_cal + 345);
                            confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openMainPage();
                                }
                            });
                        } else {
                            //150 gr
                            image_top.setImageResource(R.drawable.rice33);
                            image_bottom.setImageResource(R.drawable.side_rice33);
                            total_prot = total_prot + (total_prot + 10);
                            total_carb = total_carb + (total_carb + 115);
                            total_fat = total_fat + (total_fat + 2);
                            total_cal = total_cal + (total_cal + 518);
                            confirm.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openMainPage();
                                }
                            });
                        }
                        break;
                    case "Quick Oats":

                }


            }
        });
    }

    private void openMainPage(){
        Intent intent = new Intent(this, MainPage.class);
        intent.putExtra("cpBr", total_prot);
        intent.putExtra("ccBr", total_carb);
        intent.putExtra("cfBr", total_fat);
        intent.putExtra("cckBr", total_cal);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return imageid.length;
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

            image.setImageResource(imageid[position]);
            text.setText(foodItems[position]);

            return convertView;
        }
    }*/
}
