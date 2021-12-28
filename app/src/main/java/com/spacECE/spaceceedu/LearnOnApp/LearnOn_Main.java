package com.spacECE.spaceceedu.LearnOnApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.spacECE.spaceceedu.R;

import java.util.ArrayList;

public class LearnOn_Main extends AppCompatActivity {

    public static ArrayList<Learn> Llist = new ArrayList<>();

    public static ArrayList<LearnOn_App_MyCourse> MyCourseList = new ArrayList<>();

    Fragment fragment = new LearnOn_List();

    Fragment MyCourseFragment=new Book_LearnOn_List();

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_on_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.LearnOnMain_Frame, fragment).commit();

        bottomNavigationView=findViewById(R.id.bottom_navigation_learn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.LearnOn_course:
                        getSupportFragmentManager().beginTransaction().replace(R.id.LearnOnMain_Frame, fragment).commit();

                    case R.id.LearnOn_Mycoures:
                        getSupportFragmentManager().beginTransaction().replace(R.id.LearnOnMain_Frame, MyCourseFragment).commit();

                }
                return false;
            }
        });

    }
}
