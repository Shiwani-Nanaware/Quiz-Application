package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import io.grpc.NameResolver;

public class resultActivity3 extends AppCompatActivity {
    TextView tv,tv2,tv3;
    Button btnRestart;
    CircularProgressBar circularProgressBar;
    TextView ResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result3);
        tv = (TextView) findViewById(R.id.tvres);
        tv2 = (TextView) findViewById(R.id.tvres2);
        tv3 = (TextView) findViewById(R.id.tvres3);
        btnRestart = (Button) findViewById(R.id.btnrestart);
        ResultText = findViewById(R.id.resulttext);
        circularProgressBar = findViewById(R.id.circularprogressbar);
        circularProgressBar.setProgress(questionActivity3.correct);


        StringBuffer sb = new StringBuffer();
        sb.append("Correct Answer: " + questionActivity3.correct+ "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answer: " + questionActivity3.wrong+ "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + questionActivity3.correct+ "\n");

        StringBuffer sb4 = new StringBuffer();
        sb4.append(questionActivity3.correct + "/" + "10");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        ResultText.setText(sb4);
        questionActivity3.correct=0;
        questionActivity3.wrong=0;
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(resultActivity3.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}