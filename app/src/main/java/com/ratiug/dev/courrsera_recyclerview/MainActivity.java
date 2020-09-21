package com.ratiug.dev.courrsera_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.ratiug.dev.courrsera_recyclerview.Adapter.MultiTypesAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    List<RowType> items = new ArrayList<>();
    String[] usernameArray;
    String [] messageArray;
    int[] images;

    Random rnd = new Random();

    MultiTypesAdapter multiTypesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);

        usernameArray = getResources().getStringArray(R.array.usernames);
        messageArray = getResources().getStringArray(R.array.messages);

        images = new int[]{R.drawable.picture_1, R.drawable.picture_2, R.drawable.picture_3, R.drawable.picture_4
                ,R.drawable.picture_5,R.drawable.picture_6,R.drawable.picture_7,R.drawable.picture_8};

        for (int i = 0; i < 7; i++) {
            switch (rnd.nextInt(2)) {
                case 0 :
                    items.add(new MessageRowType("test1","messageArray"));
                    break;
                case 1 :
                    items.add(new ImageRowType());
            }
        }

        multiTypesAdapter = new MultiTypesAdapter(items,usernameArray, messageArray,images);

        recyclerView.setAdapter(multiTypesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}