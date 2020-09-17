package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    String [] mArrayUsername;
    String[] mArrayMessage;
    Context mCntext;

    public MessageAdapter(Context context, String[] usernames, String[] messages){
        mCntext = context;
        mArrayUsername = usernames;
        mArrayMessage =messages;
    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCntext);
        View view = inflater.inflate(R.layout.my_row_message_chat,parent,false);

        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.tvUsername.setText(mArrayUsername[position]);
        holder.tvMessage.setText(mArrayMessage[position]);
    }

    @Override
    public int getItemCount() {
        return mArrayMessage.length;
    }
}
