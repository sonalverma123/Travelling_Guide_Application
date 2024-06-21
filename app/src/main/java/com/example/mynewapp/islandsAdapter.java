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

public class islandsAdapter extends RecyclerView.Adapter<islandsAdapter.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<Places> islands;

    public islandsAdapter(Context context, List<Places> islands) {
        this.context=context;
        this.islands = islands;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public islandsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new islandsAdapter.ViewHolder(inflater.inflate(R.layout.islandsitemards, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull islandsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.islandName.setText(islands.get(i).getIslandsname());
        Picasso.get().load(islands.get(i).getIslandimage()).into(viewHolder.islandPhoto);
    }

    @Override
    public int getItemCount() {
        return  islands.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView islandName;
        ImageView islandPhoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            islandName=itemView.findViewById(R.id.island_name);
            islandPhoto=itemView.findViewById(R.id.island_image);
            cardView=itemView.findViewById(R.id.cv3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,aboutislands.class);
                    intent.putExtra("visit_island",islands.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
