package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.MainActivity;
import com.ratiug.dev.courrsera_recyclerview.R;

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

        LayoutInflater inflater = LayoutInflater.from(mCntext);
        View view = inflater.inflate(R.layout.my_row_recycler_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvNameLang.setText(mArrayLanguage[position]);
        holder.tvDescrip.setText(mArrayDescriptions[position]);
    }

    @Override
    public int getItemCount() {
        return mArrayDescriptions.length;
    }
}
