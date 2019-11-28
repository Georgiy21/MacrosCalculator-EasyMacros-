package com.example.gosha.easymacros2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class fatIntent extends AppCompatActivity {

    Button confirm;
    ListView foodList;

    String[] foodItems = {"Avocado", "Almond"};
    int[] imageid = {R.drawable.avocado, R.drawable.almond};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_intent);

        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        foodList = findViewById(R.id.foodList);
        CustomAdapter customAdapter = new CustomAdapter();
        foodList.setAdapter(customAdapter);
    }

    private void openMenu(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter {


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
    }
}
