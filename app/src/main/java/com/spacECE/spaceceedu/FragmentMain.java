package com.spacECE.spaceceedu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.spacECE.spaceceedu.Authentication.Account;
import com.spacECE.spaceceedu.Consultants.ConsultantCategory;
import com.spacECE.spaceceedu.Consultants.Consultant_Main;
import com.spacECE.spaceceedu.Consultants.ConsultUs_SplashScreen;
import com.spacECE.spaceceedu.LearnOnApp.LearnOn_List_SplashScreen;
import com.spacECE.spaceceedu.Library.Library_main;
import com.spacECE.spaceceedu.VideoLibrary.VideoLibrary_Activity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentMain extends Fragment {

    static Account account ;

    Button sign_signUp;
    Button signOut;
    private final int[] mImages = new int[]{
            R.drawable.view1, R.drawable.view2, R.drawable.view3,
            R.drawable.view4,R.drawable.view5
    };


    CardView cv_videoLibrary;
    CardView cv_consultation;
    CardView cv_dailyActivities;
    CardView cv_libraryBooks;
    CardView cv_learnOnApp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main,container,false);

        CarouselView carouselView = v.findViewById(R.id.MainFragement_NewsCarousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages [position]);
            }
        });

        //Navigating to VideoLibrary/Consultation activity via OnClick
        cv_consultation=v.findViewById(R.id.CardView_Consultation);
        cv_videoLibrary=v.findViewById(R.id.CardView_VideoLibrary);

        //Navigating to Daily Activities
        cv_dailyActivities = v.findViewById(R.id.CardView_MyActivities);

        //Navigating to Library Books
        cv_libraryBooks = v.findViewById(R.id.CardView_Library);

        cv_learnOnApp = v.findViewById(R.id.CardView_LearnOnApp);

        cv_videoLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent =new Intent(getContext(), VideoLibrary_Activity.class);
                myIntent.putExtra("account_id","2");
                startActivity(myIntent);
            }
        });

        cv_consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ConsultUs_SplashScreen.class);
                startActivity(intent);
            }
        });

        cv_dailyActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),ActivitiesListActivity.class);
                startActivity(intent);
            }
        });

        cv_libraryBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Library_main.class);
                startActivity(intent);
            }
        });

        cv_learnOnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LearnOn_List_SplashScreen.class);
                startActivity(intent);
            }
        });

    return v;
    }

}


