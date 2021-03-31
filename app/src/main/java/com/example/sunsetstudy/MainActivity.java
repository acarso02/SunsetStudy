package com.example.sunsetstudy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager llm = new LinearLayoutManager(this);
    private int i = 0;
    //public ProjectList projectsList = new ProjectList();
    String[] projects = {"project1", "project2", "project3", "Project4", "Project5", "Project 6", "Project7", "Projet 8"};
    int[] projectQuestionCounts = {5, 12, 3, 7, 2, 3, 9, 1};
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler_view);
        RVAdapter myAdapter = new RVAdapter(this, projects, projectQuestionCounts);
        rv.setAdapter(myAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        Button addButton = (Button) findViewById(R.id.add_question_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAdd();
            }
        });

    }

    public void openActivityAdd(){
        Intent i = new Intent(this, AddCardActivity.class);
        startActivity(i);
    }
}