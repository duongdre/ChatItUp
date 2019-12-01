package com.example.chatitup.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chatitup.MessageActivity;
import com.example.chatitup.Model.Mess;
import com.example.chatitup.Model.User;
import com.example.chatitup.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessAdapter extends RecyclerView.Adapter<MessAdapter.ViewHolder> {

    public static final int MSG_TYPE_RECEIVING = 0;
    public static final int MSG_TYPE_SENDING = 1;
    private Context mContext;
    private List<Mess> mMess;
    private String imageurl;

    FirebaseUser firebaseUser;

    public MessAdapter(Context mContext, List<Mess> mMess, String imageurl){
        this.mMess = mMess;
        this.mContext = mContext;
        this.imageurl = imageurl;
    }

    @NonNull
    @Override
    public MessAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_SENDING){
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_sending, parent, false);
            return new MessAdapter.ViewHolder(view);
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_receiving, parent, false);
            return new MessAdapter.ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull MessAdapter.ViewHolder holder, int position) {
        Mess mess = mMess.get(position);

        holder.show_mess.setText(mess.getMess());

        if (imageurl.equals("default")){
            holder.profile_image.setImageResource(R.drawable.ic_user_avatar_none);
        }else{
            Glide.with(mContext).load(imageurl).into(holder.profile_image);
        }
    }

    @Override
    public int getItemCount() {
        return mMess.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView show_mess;
        public ImageView profile_image;

        public ViewHolder(View itemView){
            super(itemView);

            show_mess = itemView.findViewById(R.id.show_mess);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mMess.get(position).getFromWho().equals(firebaseUser.getUid())){
            return MSG_TYPE_SENDING;
        }else{
            return MSG_TYPE_RECEIVING;
        }
    }
}
