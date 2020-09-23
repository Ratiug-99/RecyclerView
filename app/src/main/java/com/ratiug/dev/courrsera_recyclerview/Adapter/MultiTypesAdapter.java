package com.ratiug.dev.courrsera_recyclerview.Adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ratiug.dev.courrsera_recyclerview.ImageRowType;
import com.ratiug.dev.courrsera_recyclerview.MainActivity;
import com.ratiug.dev.courrsera_recyclerview.MessageRowType;
import com.ratiug.dev.courrsera_recyclerview.R;
import com.ratiug.dev.courrsera_recyclerview.RowType;

import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MultiTypesAdapter extends RecyclerView.Adapter {

    private List<RowType> mDataSet;
    String [] mArrayUsername;
    String[] mArrayMessage;
    int[] imgs ;
    Random rnd = new Random();


    public  MultiTypesAdapter(List<RowType> dataSet, String[] usernames, String[] messages, int[] random_images){
        this.mDataSet = dataSet;
        mArrayUsername = usernames;
        mArrayMessage =messages;
        imgs = random_images;
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSet.get(position) instanceof MessageRowType){
            return RowType.MESSAGE_ROW_TYPE;
        } else if (mDataSet.get(position) instanceof ImageRowType){
            return RowType.IMAGE_ROW_TYPE;
        }else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == RowType.MESSAGE_ROW_TYPE){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_row_message_chat, parent, false);
            return new MessageViewHolder(view);
        } else if(viewType == RowType.IMAGE_ROW_TYPE){
            View view =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_row_landscape,parent,false);
            return new LandscapeViewHolder(view);
        }
        else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MessageViewHolder) {
            ((MessageViewHolder) holder).tvUsername.setText(mArrayUsername[rnd.nextInt(7)]);
            ((MessageViewHolder) holder).tvMessage.setText(mArrayMessage[rnd.nextInt(7)]);
        } else if (holder instanceof LandscapeViewHolder) {
            ((LandscapeViewHolder) holder).landscapeImageView.setImageResource(imgs[rnd.nextInt(7)]);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //todo fix crash when click miss item

                int itemPosition = holder.getAdapterPosition();
                Log.d(TAG, "onClick: " + itemPosition);
                mDataSet.remove(itemPosition);
                notifyItemRemoved(itemPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}
