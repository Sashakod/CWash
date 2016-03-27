package com.example.cwash.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cwash.R;
import com.example.cwash.dto.OrderDTO;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    private List<OrderDTO> data;

    public OrderListAdapter(List<OrderDTO> data) {
        this.data = data;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.title_car.setText(data.get(position).getTitle_car());
        holder.title_time.setText(data.get(position).getTitle_time());
        holder.title_number.setText(data.get(position).getTitle_number());
        holder.title_price.setText(data.get(position).getTitle_price());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title_car;
        TextView title_time;
        TextView title_number;
        TextView title_price;

        public OrderViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title_car = (TextView) itemView.findViewById(R.id.title_car);
            title_time = (TextView) itemView.findViewById(R.id.title_time);
            title_number = (TextView) itemView.findViewById(R.id.title_number);
            title_price = (TextView) itemView.findViewById(R.id.title_price);
        }
    }
}
