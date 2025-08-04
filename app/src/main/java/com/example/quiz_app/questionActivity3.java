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

public class questionActivity3 extends AppCompatActivity {

    String questions[] = {
            "1. Who developed Python Programming Language?",
            "2. Which type of Programming does Python support?",
            "3. All keywords in Python are in _________",
            "4. Python supports the creation of anonymous functions at runtime, using a construct called __________",
            "5. What will be the output of the following Python code snippet if x=1? x<<2",
            "6. What does pip stand for python?",
            "7. Which of the following is not a core data type in Python programming?",
            "8. Which of the following statements is used to create an empty set in Python?",
            "9. To add a new element to a list we use which Python command?",
            "10. Which of the following is a Python tuple?",
    };
    String answer[] = {
            "Guido van Rossum",
            "all of the mentioned",
            "None of the mentioned",
            "lambda",
            "4",
            "Preferred Installer Program",
            "Class",
            "set()",
            "list1.append(5)",
            "(1, 2, 3)",
    };
    String opt[] = {
            "Wick van Rossum","Rasmus Lerdorf","Guido van Rossum"," Niene Stom",
            "object-oriented programming","structured programming","functional programming","all of the mentioned",
            "Capitalized","lower case","UPPER CASE"," None of the mentioned",
            "pi","anonymous","lambda","none of the mentioned",
            "4","2","1","8",
            "Pip Installs Python","Pip Installs Packages","Preferred Installer Program","All of the mentioned",
            "Tuples","Lists","Class","Dictionary",
            "()","[]","{}","set()",
            "list1.addEnd(5)","list1.addLast(5)","list1.append(5)","list1.add(5)",
            "{1, 2, 3}","{}","[1, 2, 3]","(1, 2, 3)",


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
        setContentView(R.layout.activity_question3);
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
                    Toast.makeText(questionActivity3.this, "Please select one choice ", Toast.LENGTH_SHORT).show();
                    return;

                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText( questionActivity3.this, "Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText( questionActivity3.this, "wrong", Toast.LENGTH_SHORT).show();
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
                        Intent in = new Intent( questionActivity3.this,resultActivity3.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),resultActivity3.class);
                startActivity(intent1);
            }
        });


    }
}