package com.spacECE.spaceceedu.LearnOnApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.spacECE.spaceceedu.MainActivity;
import com.spacECE.spaceceedu.R;
import com.spacECE.spaceceedu.UsefulFunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class LearnOn_App_SplashScreen_For_MyCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_on_app_splash_screen_for_my_course);
        LoadMyCourseList();
    }

    void LoadMyCourseList()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final JSONObject apiCallcourse;
                try{
                    apiCallcourse = UsefulFunctions.UsingGetAPI("http://educationfoundation.space/spacece/api/learnonapp_courses.php");
                    JSONArray jsonArrayOfCourse = null;
                    try {
                        try {
                            assert apiCallcourse != null;
                        } catch (AssertionError e) {

                            e.printStackTrace();

                            runOnUiThread(() -> {
                                new AlertDialog.Builder(LearnOn_App_SplashScreen_For_MyCourse.this)
                                        .setTitle("Internet Not Working!")
                                        .setMessage("Do you want to retry ?")

                                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                LoadMyCourseList();
                                            }
                                        })

                                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(LearnOn_App_SplashScreen_For_MyCourse.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        })

                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .show();
                            });

                        }
                        jsonArrayOfCourse = apiCallcourse.getJSONArray("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LearnOn_Main.MyCourseList = new ArrayList<>();
                    try {
                        for (int i = 0; i < Objects.requireNonNull(jsonArrayOfCourse).length(); i++) {
                            JSONObject response_element = new JSONObject(String.valueOf(jsonArrayOfCourse.getJSONObject(i)));
                            LearnOn_App_MyCourse temp = new LearnOn_App_MyCourse(response_element.getString("id"), response_element.getString("title"),
                                    response_element.getString("description"), response_element.getString("type"),
                                    response_element.getString("mode"), response_element.getString("duration"),
                                    response_element.getString("price"));
                            LearnOn_Main.MyCourseList.add(temp);
                        }
                        Log.d("Display",LearnOn_Main.MyCourseList.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent(LearnOn_App_SplashScreen_For_MyCourse.this, LearnOn_Main.class);
                    startActivity(intent);
                    finish();

                } catch ( Exception e) {
                    Log.i("EXCEPTION", e.toString());
                }
            }
        });

        thread.start();
    }

}