package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.R;

public class LandscapeViewHolder extends RecyclerView.ViewHolder {
    AppCompatImageView landscapeImageView;

    public LandscapeViewHolder(@NonNull View itemView) {
        super(itemView);
        landscapeImageView = itemView.findViewById(R.id.ivLandscape);
    }
}
