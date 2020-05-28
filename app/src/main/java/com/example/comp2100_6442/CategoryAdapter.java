package com.example.comp2100_6442;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
private List<TypeModel> typeModelList;

    public CategoryAdapter(List<TypeModel> typeofsurveylist) {
        this.typeModelList = typeofsurveylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
           return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(typeModelList.get(position).getImageUrl(),typeModelList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return typeModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imageview;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);

        }
        private void setData(String url, String title){
            Glide.with(itemView.getContext()).load(url).into(imageview);
            this.title.setText(title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent questionIntent = new Intent(itemView.getContext(), QuestionsActivity.class);
                    itemView.getContext().startActivity(questionIntent);
                }
            });
        }
    }


}
