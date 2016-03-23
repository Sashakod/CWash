package com.example.cwash.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cwash.R;
import com.example.cwash.dto.CarDTO;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder> {

    private List<CarDTO> data;

    public CarListAdapter(List<CarDTO> data) {
        this.data = data;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        holder.title_car.setText(data.get(position).getTitle_car());
        holder.title_time.setText(data.get(position).getTitle_time());
        holder.title_number.setText(data.get(position).getTitle_number());
        holder.title_price.setText(data.get(position).getTitle_price());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView title_car;
        TextView title_time;
        TextView title_number;
        TextView title_price;

        public CarViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title_car = (TextView) itemView.findViewById(R.id.title_car);
            title_time = (TextView) itemView.findViewById(R.id.title_time);
            title_number = (TextView) itemView.findViewById(R.id.title_number);
            title_price = (TextView) itemView.findViewById(R.id.title_price);
        }
    }
}
