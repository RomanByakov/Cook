package com.codetek.roman.cook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Roman on 18.10.2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.TrackViewHolder> {

    public static class TrackViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView textView;
        ImageView imageView;

        TrackViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    String[] array;
    Integer[] images;
    boolean isRecept;
    Context context;

    Adapter(String[] array, Integer[] images, boolean isRecept,Context context) {
        this.images = images;
        this.array = array;
        this.isRecept = isRecept;
        this.context = context;

    }

    @Override
    public TrackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        TrackViewHolder tvh = new TrackViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(TrackViewHolder holder, int position) {
        holder.textView.setText(array[position]);
        holder.imageView.setImageResource(images[position]);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRecept) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("bool", true);
                    intent.putExtra("page",((TextView) view.findViewById(R.id.textView)).getText());
                    context.startActivity(intent);
                }
                else
                {
                    // detail
                    Intent intent = new Intent(context, Recept.class);
                    intent.putExtra("bool", true);
                    intent.putExtra("page",((TextView) view.findViewById(R.id.textView)).getText());
                    context.startActivity(intent);
                    Toast.makeText(context,((TextView)view.findViewById(R.id.textView)).getText(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.length;
    }
}
