package com.example.mynewapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {
    List<Places> cityData;
    Context context;
    LayoutInflater inflater;

    public SecondAdapter( Context context, List<Places> cityData) {
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.cityData = cityData;
        this.context=context;
    }

    @NonNull
    @Override
    public SecondAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SecondAdapter.ViewHolder(inflater.inflate(R.layout.secondcards, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SecondAdapter.ViewHolder viewHolder, int i) {
        viewHolder.CityName.setText(cityData.get(i).getPlace());
        Picasso.get().load(cityData.get(i).getImage()).into(viewHolder.CityPhoto);
        //viewHolder.CityPhoto.setImageResource(cityData.get(i).image);
    }

    @Override
    public int getItemCount() {
        return cityData.size();
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
            CityName=itemView.findViewById(R.id.city_name2);
            cardView=itemView.findViewById(R.id.cv2);
            CityPhoto=itemView.findViewById(R.id.card_image2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,AboutCities.class);
                    intent.putExtra("visit_place",cityData.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }

    }
}