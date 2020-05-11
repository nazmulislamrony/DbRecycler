package com.example.dbrecycler.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbrecycler.Mode.SecondStore;
import com.example.dbrecycler.Mode.Store;
import com.example.dbrecycler.R;

import java.util.List;

public class SecondRecyclerAdapter extends RecyclerView.Adapter<SecondRecyclerAdapter.MyViewHolder> {


    public static com.example.dbrecycler.RecyclerView.RecyclerView.ClickListener clickListener;

    private Context context;
    private List<SecondStore> secondStores;

    public SecondRecyclerAdapter(Context context, List<SecondStore> secondStores) {
        this.context = context;
        this.secondStores = secondStores;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.view_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(secondStores.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return secondStores.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.textListing);

        }
    }
}
