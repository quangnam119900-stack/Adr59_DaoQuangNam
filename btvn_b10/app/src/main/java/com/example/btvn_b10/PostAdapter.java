package com.example.btvn_b10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private final List<Post> postList;

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Post post = postList.get(position);

        holder.tvPostId.setText("Post #" + post.getId());
        holder.tvPostTitle.setText(post.getTitle());
        holder.tvPostBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvPostId;
        TextView tvPostTitle;
        TextView tvPostBody;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPostId = itemView.findViewById(R.id.tvPostId);
            tvPostTitle = itemView.findViewById(R.id.tvPostTitle);
            tvPostBody = itemView.findViewById(R.id.tvPostBody);
        }
    }
}