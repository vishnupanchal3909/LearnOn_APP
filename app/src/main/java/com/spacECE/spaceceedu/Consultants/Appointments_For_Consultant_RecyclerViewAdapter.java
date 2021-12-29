package com.spacECE.spaceceedu.Consultants;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacECE.spaceceedu.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.spacECE.spaceceedu.Consultants.Consultant_Main.SetDateTimeDay;

public class Appointments_For_Consultant_RecyclerViewAdapter extends RecyclerView.Adapter<Appointments_For_Consultant_RecyclerViewAdapter.MyViewHolder> {

    ArrayList<Appointment> myConsultants;
    private RecyclerViewClickListener listener;

    public Appointments_For_Consultant_RecyclerViewAdapter(ArrayList<Appointment> myConsultants, RecyclerViewClickListener listener) {
        this.myConsultants = myConsultants;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name, date, day, time;
        private ImageView profile;
        private ImageButton call;

        public MyViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.Consultant_Consultants_textView_Name);
            profile = view.findViewById(R.id.Consultant_Consultants_ImageView_ProfilePic);
            day = view.findViewById(R.id.Consultant_Consultants_textView_Day);
            date = view.findViewById(R.id.Consultant_Consultants_textView_Date);
            time = view.findViewById(R.id.Consultant_Consultants_textView_Timing);
            call = view.findViewById(R.id.bCall);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {listener.onClick(view, getAdapterPosition()); }
    }

    @NonNull
    @Override
    public Appointments_For_Consultant_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.consultus_appointments_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String name = myConsultants.get(position).getU_name();
        SetDateTimeDay(position, myConsultants, holder.date, holder.time, holder.day);
        holder.name.setText("User "+name);
        Picasso.get().load(R.drawable.default_profilepic).into(holder.profile);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Agoraa.class);
                intent.putExtra("c_id", myConsultants.get(holder.getAdapterPosition()).getConsult_id());
                intent.putExtra("c_name", myConsultants.get(holder.getAdapterPosition()).getC_name());
                intent.putExtra("c_pic", myConsultants.get(holder.getAdapterPosition()).getC_pic());
                intent.putExtra("u_name", myConsultants.get(holder.getAdapterPosition()).getU_name());
                intent.putExtra("c_pic", myConsultants.get(holder.getAdapterPosition()).getU_pic());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myConsultants.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }

}