package com.example.luxchat.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luxchat.R;
import com.firebase.ui.auth.data.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUsers;

    public UserAdapter(Context mContext,List<User> mUsers){
       this.mContext= mContext;
       this.mUsers= mUsers;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.user_item,viewGroup,false);
        return new UserAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User user=mUsers.get(i);





        

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder{
        public TextView username;
        public ImageView profile_user;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username =itemView.findViewById(R.id.tvNameuser);
            profile_user= itemView.findViewById(R.id.profile_user);
        }
    }

}


