package com.example.mynewapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<Places> cityyy;

    public RVadapter(Context context, List<Places> cityyy) {
        this.context=context;
        this.cityyy = cityyy;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RVadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.recycle_itemcards, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       viewHolder.CityName.setText(cityyy.get(i).getPlace());
        Picasso.get().load(cityyy.get(i).getImage()).into(viewHolder.CityPhoto);
       //viewHolder.CityPhoto.setImageResource(cityyy.get(i).image);
    }

    @Override
    public int getItemCount() {
        return  cityyy.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView CityName;
        ImageView CityPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            CityName = itemView.findViewById(R.id.city_name);
            CityPhoto = itemView.findViewById(R.id.card_image);
            cardView=itemView.findViewById(R.id.cv);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(context,TourDetailActivity.class);
                   intent.putExtra("place_data",cityyy.get(getAdapterPosition()));
                   context.startActivity(intent);
               }
           });


                }

        }

}