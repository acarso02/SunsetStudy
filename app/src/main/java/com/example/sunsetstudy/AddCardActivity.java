package com.example.sunsetstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity{
    private Button subButton;
    private EditText mEditQuestion, mEditAnswer;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card);
        subButton = (Button)findViewById(R.id.submitButton);

        subButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String question, answer;

                mEditQuestion = (EditText)findViewById(R.id.questionBox);
                mEditAnswer = (EditText)findViewById(R.id.answerBox);
                question = mEditQuestion.getText().toString();
                answer = mEditAnswer.getText().toString();

                if(question.matches("")){
                    //alert field is blank
                }
                else{
                    //add card to the selected project
                    MainActivity.projectList.get(0).addCard(question, answer);
                    Toast.makeText(getApplicationContext(), "Submitted!",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
                mText = (TextView)findViewById(R.id.textView1);
                mText.setText("Welcome "+mEditQuestion.getText().toString()+"!");
            }
        });

    }



}
