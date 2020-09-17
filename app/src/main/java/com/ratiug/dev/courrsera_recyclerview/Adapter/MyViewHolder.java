package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tvNameLang, tvDescrip;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNameLang = itemView.findViewById(R.id.tvNameLanguage);
        tvDescrip = itemView.findViewById(R.id.tvDescription);
    }
}
