package com.example.mydigitalbloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class Adapter extends FirebaseRecyclerAdapter<peopleInformation,Adapter.MyViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter(@NonNull FirebaseRecyclerOptions<peopleInformation> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull peopleInformation model) {
        holder.adress1.setText(model.getAddress());
        holder. age1.setText(model.getAge());
        holder.  bloodgroup1.setText(model.getBloodgroup());
        holder.dateofdonation1.setText(model.getDod());
        holder.username1.setText(model.getName());
        holder.phonenumber1.setText(model.getPhone());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder,parent,false);
       return  new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView adress1, age1,bloodgroup1, dateofdonation1,username1,phonenumber1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            adress1=itemView.findViewById(R.id.address);
            age1=itemView.findViewById(R.id.age);
            bloodgroup1=itemView.findViewById(R.id.bloodgroup);
            dateofdonation1=itemView.findViewById(R.id.dod);
            username1=itemView.findViewById(R.id.username);
            phonenumber1=itemView.findViewById(R.id.phonenumber);


        }
    }
}
