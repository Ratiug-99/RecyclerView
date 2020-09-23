package com.ratiug.dev.courrsera_recyclerview;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.Adapter.MultiTypesAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public static final String TAG = "DBG | MainActivity";
    List<RowType> items = new ArrayList<>();
    String[] usernameArray;
    String[] messageArray;
    int[] images;

    String LIST_STATE_KEY ="LIST_STATE_KEY";

    RecyclerView.LayoutManager mLM = new LinearLayoutManager(this);

    MultiTypesAdapter multiTypesAdapter;
    private Parcelable mListState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list);

        usernameArray = getResources().getStringArray(R.array.usernames);
        messageArray = getResources().getStringArray(R.array.messages);

        images = new int[]{R.drawable.picture_1, R.drawable.picture_2, R.drawable.picture_3, R.drawable.picture_4
                , R.drawable.picture_5, R.drawable.picture_6, R.drawable.picture_7, R.drawable.picture_8};

        items.add(new MessageRowType());
        items.add(new ImageRowType());
        Log.d(TAG, "onCreate: ");
        multiTypesAdapter = new MultiTypesAdapter(items, usernameArray, messageArray, images);



        recyclerView.setAdapter(multiTypesAdapter);
        recyclerView.setLayoutManager(mLM);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.addMessageAction:
                Toast.makeText(this, "Add Message Row", Toast.LENGTH_SHORT).show();
                items.add(new MessageRowType());
                multiTypesAdapter.notifyItemInserted(multiTypesAdapter.getItemCount());
                recyclerView.scrollToPosition(multiTypesAdapter.getItemCount() - 1);
                break;
            case R.id.addPictureAction:
                Toast.makeText(this, "Add Picture Row", Toast.LENGTH_SHORT).show();
                items.add(new ImageRowType());
                multiTypesAdapter.notifyItemInserted(multiTypesAdapter.getItemCount());
                recyclerView.scrollToPosition(multiTypesAdapter.getItemCount() - 1);
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        Log.d(TAG, "onSaveInstanceState: " + items.size());
        // Save list state
        mListState = mLM.onSaveInstanceState();
        state.putParcelable(LIST_STATE_KEY, mListState);
    }

    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        Log.d(TAG, "onRestoreInstanceState: ");
        // Retrieve list state and list/item positions
        if(state != null)
            mListState = state.getParcelable(LIST_STATE_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + items.size());
        if (mListState != null) {
            mLM.onRestoreInstanceState(mListState);
            recyclerView.setLayoutManager(mLM);
        }
    }


}