package com.example.cwash.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cwash.R;
import com.example.cwash.dto.CategoryDTO;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>{

    private List<CategoryDTO> data;

    public CategoryListAdapter(List<CategoryDTO> data) {
        this.data = data;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title_name;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.categotyView);
            title_name = (TextView) itemView.findViewById(R.id.title_name);
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.title_name.setText(data.get(position).getTitle_name());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
