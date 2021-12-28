package com.spacECE.spaceceedu.LearnOnApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.spacECE.spaceceedu.R;

import java.util.ArrayList;

public class LearnOn_App_RecyclerAdapter_For_Mycourse extends RecyclerView.Adapter<LearnOn_App_RecyclerAdapter_For_Mycourse.MyViewHolder> {

    ArrayList<LearnOn_App_MyCourse> Mylist=LearnOn_Main.MyCourseList;

    private final LearnOn_App_RecyclerAdapter_For_Mycourse.RecyclerViewClickListenerMycourse listener;

    public LearnOn_App_RecyclerAdapter_For_Mycourse(ArrayList<LearnOn_App_MyCourse> mylist, RecyclerViewClickListenerMycourse listener) {
        this.Mylist = mylist;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tv_category;
        private final Button tv_enroll;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_category = itemView.findViewById(R.id.LearnOn_List_ListItem_TextView_CategoryName);
            itemView.setOnClickListener(this);
            tv_enroll = itemView.findViewById(R.id.Enroll);
//            tv_enroll.setOnClickListener(v -> {
//
//                Intent intent = new Intent(tv_enroll.getContext(), Payment.class);
//                tv_enroll.getContext().startActivity(intent);
//            });
        }

        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public LearnOn_App_RecyclerAdapter_For_Mycourse.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.learnon_list_item_in_mycourse, parent, false);
        return new LearnOn_App_RecyclerAdapter_For_Mycourse.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_category.setText(Mylist.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return Mylist.size();
    }

    public interface RecyclerViewClickListenerMycourse {
        void onClick(View v, int position);
    }
}
