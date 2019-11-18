package com.example.sugarv5.RecyclerViewStuff;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sugarv5.R;

import java.util.ArrayList;

public class MeasuresAdapter extends RecyclerView.Adapter<MeasuresAdapter.MeasuresViewHolder> {
    private ArrayList<MeasuresItem> mMeasuresList;

    public static class MeasuresViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1, mTextView2;

        public MeasuresViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_Signal);
            mTextView1 = itemView.findViewById(R.id.txt_MeasureData);
            mTextView2 = itemView.findViewById(R.id.txt_DateTimeData);
        }
    }

    public MeasuresAdapter(ArrayList<MeasuresItem> measuresList) {
        mMeasuresList = measuresList;
    }

    @NonNull
    @Override
    public MeasuresViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.measure_item,viewGroup,false);
        MeasuresViewHolder mvh = new MeasuresViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MeasuresViewHolder holder, int position) {
        MeasuresItem currentItem = mMeasuresList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mMeasuresList.size();
    }
}
