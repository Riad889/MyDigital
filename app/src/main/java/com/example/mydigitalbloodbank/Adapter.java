package com.example.mydigitalbloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    ArrayList<peopleInformation>list;

    public Adapter(ArrayList<peopleInformation> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder. adress1.setText(list.get(position).getAddress());
        holder. age1.setText(list.get(position).getAge());
        holder. bloodgroup1.setText(list.get(position).getBloodgroup());
        holder. dateofdonation1.setText(list.get(position).getDod());
        holder. username1.setText(list.get(position).getName());
        holder. phonenumber1.setText(list.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
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
