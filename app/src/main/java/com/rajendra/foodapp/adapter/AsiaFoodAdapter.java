package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.foodapp.DetailsActivity;
import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.AsiaFood;
import com.rajendra.foodapp.model.PopularFood;

import java.util.List;


public class AsiaFoodAdapter extends RecyclerView.Adapter<AsiaFoodAdapter.AsiaFoodViewHolder> {
    public static String nameV,priceV;
    public static int imgV;
    Context context;
    List<AsiaFood> asiaFoodList;



    public AsiaFoodAdapter(Context context, List<AsiaFood> asiaFoodList) {
        this.context = context;
        this.asiaFoodList = asiaFoodList;
    }

    @NonNull
    @Override
    public AsiaFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.asia_food_row_item, parent, false);
        return new AsiaFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder( AsiaFoodViewHolder holder, int position) {

        holder.foodImage.setImageResource(asiaFoodList.get(position).getImageUrl());
        holder.name.setText(asiaFoodList.get(position).getName());
        holder.price.setText(asiaFoodList.get(position).getPrice());
        holder.rating.setText(asiaFoodList.get(position).getRating());
        holder.restorantName.setText(asiaFoodList.get(position).getRestorantname());

        final String name = asiaFoodList.get(position).getName();
        final int img = asiaFoodList.get(position).getImageUrl();
        final  String price = asiaFoodList.get(position).getPrice();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, DetailsActivity.class);
                nameV=name;
                priceV=price;
                imgV=img;
                context.startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return asiaFoodList.size();
    }


    public static final class AsiaFoodViewHolder extends RecyclerView.ViewHolder{


        ImageView foodImage;
        TextView price, name, rating, restorantName;

        public AsiaFoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food_image);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            restorantName = itemView.findViewById(R.id.restorant_name);



        }
    }

}
