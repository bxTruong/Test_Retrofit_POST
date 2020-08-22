package com.example.test_retrofit_post.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_retrofit_post.R;
import com.example.test_retrofit_post.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private List<User> userList;
    private Context context;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user, parent, false);
        UserHolder userHolder = new UserHolder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User user = userList.get(position);
        holder.tvFullNameUserItem.setText(user.getName());
        holder.tvUserNameUserItem.setText(user.getUsername());
        holder.tvIdUserItem.setText(user.getId()+"");
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        public ImageView imgUser;
        public TextView tvFullNameUserItem;
        public TextView tvUserNameUserItem;
        public TextView tvIdUserItem;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgUser);
            tvFullNameUserItem = itemView.findViewById(R.id.tvFullName_User_Item);
            tvUserNameUserItem = itemView.findViewById(R.id.tvUserName_User_Item);
            tvIdUserItem = itemView.findViewById(R.id.tvId_User_Item);
        }
    }

}
