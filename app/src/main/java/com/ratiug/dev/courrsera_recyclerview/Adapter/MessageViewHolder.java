package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    TextView tvUsername, tvMessage;


    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        tvUsername = itemView.findViewById(R.id.tvUsername);
        tvMessage = itemView.findViewById(R.id.tvMessageText);
    }
}
