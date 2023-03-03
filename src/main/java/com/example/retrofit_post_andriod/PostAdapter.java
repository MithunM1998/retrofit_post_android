package com.example.retrofit_post_andriod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    List<Post> listpost;
    Context context;

    PostAdapter(Context context,List<Post> list){
        this.context=context;
        this.listpost=list;
    }
    @NonNull
    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.MyViewHolder holder, int position) {
        Post post=listpost.get(position);
        holder.title.setText("title:- "+post.getTitle());
        holder.body.setText("Body:- "+post.getBody());
    }

    @Override
    public int getItemCount() {
        return listpost.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
