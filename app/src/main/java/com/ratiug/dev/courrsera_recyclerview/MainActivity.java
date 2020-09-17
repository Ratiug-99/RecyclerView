package com.ratiug.dev.courrsera_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ratiug.dev.courrsera_recyclerview.Adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String[] languagesArray;
    String [] descriptionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);

        languagesArray = getResources().getStringArray(R.array.usernames);
        descriptionArray = getResources().getStringArray(R.array.messages);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, languagesArray,descriptionArray);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}