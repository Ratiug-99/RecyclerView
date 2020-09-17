package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    String [] mArrayLanguage;
    String[] mArrayDescriptions;
    Context mCntext;

    public MyAdapter(Context context, String[] languages, String[] descriptions){
        mCntext = context;
        mArrayLanguage = languages;
        mArrayDescriptions =descriptions;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
