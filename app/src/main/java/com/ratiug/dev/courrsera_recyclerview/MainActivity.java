package com.ratiug.dev.courrsera_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ratiug.dev.courrsera_recyclerview.Adapter.MessageAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String[] usernameArray;
    String [] messageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);

        usernameArray = getResources().getStringArray(R.array.usernames);
        messageArray = getResources().getStringArray(R.array.messages);

        MessageAdapter messageAdapter = new MessageAdapter(MainActivity.this, usernameArray,messageArray);

        recyclerView.setAdapter(messageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}