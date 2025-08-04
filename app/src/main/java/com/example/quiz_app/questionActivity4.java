package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class questionActivity4 extends AppCompatActivity {

    String questions[] = {
            "1. What does the abbreviation HTML stand for?",
            "2. The correct sequence of HTML tags for starting a webpage is -",
            "3. Which of the following element is responsible for making the text bold in HTML?",
            "4. Which of the following tag is used to insert a line-break in HTML?",
            "5. How to create an unordered list (a list with the list items in bullets) in HTML?",
            "6. How to insert an image in HTML?",
            "7. How to add a background color in HTML?",
            "8. Which of the following tag is used to make the underlined text?",
            "9. How to create a checkbox in HTML?",
            "10. Which of the following tag is used to define options in a drop-down selection list?"
    };
    String answer[] = {
            "HyperText Markup Language",
            "HTML, Head, Title, Body",
            "<b>",
            "<br>",
            "<ul>",
            "<img src = jtp.png/>",
            "<marquee bgcolor = red>",
            "<u>",
            "<input type = checkbox>",
            "<option>"

    };
    String opt[] = {
            "HighText Machine Language","HyperText and links Markup Language","HyperText Markup Language","None of these",
            "Head, Title, HTML, body","HTML, Body, Title, Head","HTML, Head, Title, Body","HTML, Head, Title, Body",
            "<pre>","<a>","<b>","<br>>",
            "<br>","<a>","<pre>","<b>",
            "<ul>","<ol>","<li>","<i>",
            "<img href = jtp.png/>","<img url = jtp.png/>","<img link = jtp.png/>","<img src = jtp.png/>",
            "<marquee bg color: red>","<marquee bg-color = red>","<marquee bgcolor = red>","<marquee color = red>",
            "<i>","<ul>","<u>","<pre>",
            "<input type = checkbox>","<input type = button>","<checkbox>","<input type = check>",
            "<select>","<list>","<dropdown>","<option>"




    };
    int flag = 0;
    public static int marks=0,correct=0,wrong=0;
    TextView tv;
    Button submitbutton,quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private TextView Questionnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        final TextView score = (TextView) findViewById(R.id.textview4);
        TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();


        Questionnumber = findViewById(R.id.DispName);
        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);
        tv = findViewById(R.id.tvque);
        radio_g = (RadioGroup) findViewById(R.id.answergroup);
        rb1 = (RadioButton) findViewById(R.id.radiobutton);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        rb4 = (RadioButton) findViewById(R.id.radiobutton4);

        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[2]);
        rb3.setText(opt[3]);
        rb4.setText(opt[4]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()== -1)
                {
                    Toast.makeText(questionActivity4.this, "Please select one choice ", Toast.LENGTH_SHORT).show();
                    return;

                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText( questionActivity4.this, "Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText( questionActivity4.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(score!=null)
                {
                    score.setText(""+correct);

                    if(flag<questions.length)
                    {
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag*4]);
                        rb2.setText(opt[flag*4 + 1]);
                        rb3.setText(opt[flag*4 + 2]);
                        rb4.setText(opt[flag*4 + 3]);
                        BreakIterator questionnumber;
                        Questionnumber.setText(flag+"/"+questions.length+" Question");
                    }
                    else {
                        marks=correct;
                        Intent in = new Intent( questionActivity4.this,resultActivity4.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),resultActivity4.class);
                startActivity(intent1);
            }
        });


    }
}