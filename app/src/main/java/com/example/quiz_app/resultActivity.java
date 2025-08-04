package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import io.grpc.NameResolver;

public class resultActivity extends AppCompatActivity {
TextView tv,tv2,tv3;
Button btnRestart;
CircularProgressBar circularProgressBar;
TextView ResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = (TextView) findViewById(R.id.tvres);
        tv2 = (TextView) findViewById(R.id.tvres2);
        tv3 = (TextView) findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnrestart);
        ResultText = findViewById(R.id.resulttext);
        circularProgressBar = findViewById(R.id.circularprogressbar);
        circularProgressBar.setProgress(questionActivity.correct);


        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answer: " + questionActivity.correct+ "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answer: " + questionActivity.wrong+ "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + questionActivity.correct+ "\n");

        StringBuffer sb4 = new StringBuffer();
        sb4.append(questionActivity.correct + "/" + "10");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        ResultText.setText(sb4);
        questionActivity.correct=0;
        questionActivity.wrong=0;
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(resultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}