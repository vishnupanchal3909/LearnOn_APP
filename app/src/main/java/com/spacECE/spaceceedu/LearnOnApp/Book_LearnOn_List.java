package com.spacECE.spaceceedu.LearnOnApp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.spacECE.spaceceedu.R;

import java.util.ArrayList;


public class Book_LearnOn_List extends Fragment {

    private RecyclerView ListRecyclerViewOfMyCourse;
    private LearnOn_App_RecyclerAdapter_For_Mycourse.RecyclerViewClickListenerMycourse listenerMycourse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book__learn_on__list, container, false);

        v.setBackgroundColor(Color.WHITE);

        Window window = getActivity().getWindow();

        window.setStatusBarColor(Color.rgb(200,100,50));

        ListRecyclerViewOfMyCourse = v.findViewById(R.id.LearnOn_List_RecyclerView_MyCourse);

        ArrayList<LearnOn_App_MyCourse> learnOn_app_myCourseArrayList=LearnOn_Main.MyCourseList;

        setAdapter(learnOn_app_myCourseArrayList);

        return v;
    }

    private void setAdapter(ArrayList<LearnOn_App_MyCourse> learnOn_app_myCourseArrayList) {
        setOnClickListener();

        LearnOn_App_RecyclerAdapter_For_Mycourse adapter_for_mycourse=new LearnOn_App_RecyclerAdapter_For_Mycourse(learnOn_app_myCourseArrayList,listenerMycourse);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false);

        ListRecyclerViewOfMyCourse.setLayoutManager(layoutManager);

        ListRecyclerViewOfMyCourse.setItemAnimator(new DefaultItemAnimator());

        ListRecyclerViewOfMyCourse.setAdapter(adapter_for_mycourse);
    }

    private void setOnClickListener() {
        listenerMycourse = (v, position) -> {
            Intent intent = new Intent(getContext(), LearnDetailed.class);
            intent.putExtra("pos", position);
            startActivity(intent);
        };
    }

}