package com.example.myapplication.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.Deker;
import com.example.myapplication.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdhkarListAdapter extends RecyclerView.Adapter<AdhkarListAdapter.DhekerViewHolder> {
    private ArrayList<Deker> Adhkar = new ArrayList<>();
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }
    @NonNull
    @Override
    public AdhkarListAdapter.DhekerViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deker_item_list, parent, false);
        DhekerViewHolder evh = new DhekerViewHolder(v, mListener);
        return  evh;
    }

    public void setAdhkarList(ArrayList<Deker> Adhkar)
    {
        this.Adhkar = Adhkar;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder (@NonNull AdhkarListAdapter.DhekerViewHolder holder, int position){

        holder.deker.setText(this.Adhkar.get(position).getDeker());
        holder.repetition.setText(String.valueOf(this.Adhkar.get(position).getRepetition()));

    }

    @Override
    public int getItemCount (){
        return this.Adhkar.size();
    }

    public class DhekerViewHolder extends RecyclerView.ViewHolder {
        TextView deker ;
        TextView repetition;
        ImageView fav_btn;
        public DhekerViewHolder (@NonNull View itemView , final OnItemClickListener listener){
            super(itemView);
            deker = itemView.findViewById(R.id.deker_taxt);
            repetition = itemView.findViewById(R.id.repetetion_number);
            fav_btn = itemView.findViewById(R.id.fav_btn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }}}});
            fav_btn.setOnClickListener(view ->{
                        setFavorite();
            });
        }

        private void setFavorite (){
            fav_btn.setImageResource(R.drawable.ic_baseline_favorite);
        }
    }


}
