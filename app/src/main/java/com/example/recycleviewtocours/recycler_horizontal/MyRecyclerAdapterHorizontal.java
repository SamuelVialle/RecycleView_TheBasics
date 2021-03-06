package com.example.recycleviewtocours.recycler_horizontal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewtocours.R;
import com.example.recycleviewtocours.SecondeActivity;


public class MyRecyclerAdapterHorizontal extends RecyclerView.Adapter<MyRecyclerViewHolderHorizontal> {

    String[] stagiaires, descs;
    int[] avatars;
    Context context;

    public MyRecyclerAdapterHorizontal(Context context, String[] stagiaires, String[] descs, int[] avatars) {
        this.context = context;
        this.stagiaires = stagiaires;
        this.descs = descs;
        this.avatars = avatars;
    }

    @NonNull
    @Override
    public MyRecyclerViewHolderHorizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler_horizontal, parent, false);
        return new MyRecyclerViewHolderHorizontal(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolderHorizontal holder, int position) {
        position = holder.getAbsoluteAdapterPosition();

        holder.stagiaire.setText(stagiaires[position]);
        holder.avatar.setImageResource(avatars[position]);

        // Utilisation normale
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
        // Utilisation d'un lambda
        holder.mainLayout.setOnClickListener(v -> {
             {
                Intent intent = new Intent(context, SecondeActivity.class);
                intent.putExtra("stagiaire", stagiaires[holder.getBindingAdapterPosition()]);
                intent.putExtra("desc", descs[holder.getBindingAdapterPosition()]);
                intent.putExtra("avatar", avatars[holder.getBindingAdapterPosition()]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }
}
