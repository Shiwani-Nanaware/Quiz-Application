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

public class questionActivity2 extends AppCompatActivity {

    String questions[] = {
            "1. Who invented C++?",
            "2. Which of the following user-defined header file extension used in c++?",
            "3. Which of the following correctly declares an array in C++?",
            "4. Which of the following approach is used by C++?",
            "5. By default, all the files in C++ are opened in _________ mode.",
            "6. Which is more effective while calling the C++ functions?",
            "7. Which of the following is used to terminate the function declaration in C++?",
            "8. The C++ code which causes abnormal termination/behaviour of a program should be written under _________ block.",
            "9. What is Inheritance in C++?",
            "10.  Which of the following symbol is used to declare the preprocessor directives in C++?",



    };
    String answer[] = {
            "Bjarne Stroustrup",
            "h",
            "Friend constructor",
            "Bottom-up",
            "Text",
            "call by reference",
            ";",
            "try",
            "Deriving new classes from existing classes",
            "#",
    };
    String opt[] = {
            "Dennis Ritchie","Brian Kernighan","Ken Thompson","Bjarne Stroustrup",
            "hg","cpp","h","hf",
            "Default constructor","Parameterized constructor","Copy constructor","Friend constructor",
            "Left-right","Right-left","Bottom-up","Top-down",
            "Binary","VTC","Text"," ISCII",
            "call by object","all by pointer","call by value","call by reference",
            ";","]",")",":",
            "catch","throw","try","finally",
            "Deriving new classes from existing classes","Overloading of classes","Classes with same names","Wrapping of data into a single class",
            "$","^","#","*",


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
        setContentView(R.layout.activity_question2);
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
                    Toast.makeText(questionActivity2.this, "Please select one choice ", Toast.LENGTH_SHORT).show();
                    return;

                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText( questionActivity2.this, "Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText( questionActivity2.this, "wrong", Toast.LENGTH_SHORT).show();
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
                        Intent in = new Intent( questionActivity2.this,resultActivity2.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),resultActivity2.class);
                startActivity(intent1);
            }
        });


    }
}