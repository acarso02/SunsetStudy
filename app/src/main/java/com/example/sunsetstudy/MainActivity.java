package com.example.sunsetstudy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager llm = new LinearLayoutManager(this);
    public static ArrayList<Project> projectList = new ArrayList<>();
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        projectList.add(new Project("Proj one"));
        projectList.add(new Project("Proj two"));
        projectList.add(new Project("Proj three"));

        //saveData();
        Button addButton = (Button) findViewById(R.id.add_question_button);
        Button questionScreen = (Button) findViewById(R.id.button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAdd();
            }
        });
        questionScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityQuestions();
            }
        });
    }
    protected void onStart() {

        super.onStart();
        rv = findViewById(R.id.recycler_view);
        RVAdapter myAdapter = new RVAdapter(this, projectList);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(projectList);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        projectList = gson.fromJson(json, type);
        if (projectList == null) {
            projectList = new ArrayList<>();
        }
    }

    public void openActivityAdd(){
        Intent i = new Intent(this, AddCardActivity.class);
        startActivity(i);
    }

    public void openActivityQuestions(){
        Intent i = new Intent(this, QuestionsActivity.class);
        startActivity(i);
    }
}