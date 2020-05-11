package com.example.dbrecycler.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dbrecycler.Mode.Store;
import com.example.dbrecycler.R;

import java.util.List;

public class RecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerView.MyViewHolder> {

    public static ClickListener clickListener;

    private Context context;
    private List<Store> store;

    public RecyclerView(Context context, List<Store> store) {
        this.context = context;
        this.store = store;
    }

    @NonNull
    @Override
    public RecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.view_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.MyViewHolder holder, int position) {
        holder.name.setText(store.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return store.size();
    }











     class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.textListing);
            itemView.setOnClickListener(this);
        }


         @Override
         public void onClick(View v) {
            clickListener.OnItemClickListener(getAdapterPosition(),v);
         }
     }

     public interface ClickListener{
        void OnItemClickListener(int position, View v);
     }

     public void setOnItemClickListener(ClickListener clickListener){
        RecyclerView.clickListener=clickListener;
     }

}
