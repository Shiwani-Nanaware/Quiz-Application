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

public class questionActivity extends AppCompatActivity {


    String questions[] = {
            "1. In the C language, the constant is defined _______.",
            "2. Each instance of a class has a different set of",
            "3. How many instances of a class can be declared?",
            "4. In which year was C language developed?",
            "5. C is a ___.",
            "6. Who is the father of C language?",
            "7. Which of the following is not a valid C variable name?",
            "8. All keywords in C are in ____________",
            "9. scanf() is a predefined function in______header file.",
            "10. In C language, FILE is of which data type?",
    };
    String answer[] = {
            "Anywhere, but starting on a new line.",
            "Attribute values",
            "As per required",
            "1972",
            "Medium level language",
            "Dennis Ritchie",
            "int $main;",
            "LowerCase letters",
            "stdio. h",
            "struct",
    };
    String opt[] = {
            "Before main", "After main", "Anywhere, but starting on a new line.", "None of the these.",
            "Methods", "Class interfaces", "Return types", "Attribute values",
            "1", "10", "As per required", "None of the these",
            "1962", "1978", "1979", "1972",
            "Low level language", "High level language", "Medium level language", "None of the above",
            "Steve Jobs", "James Gosling", "Dennis Ritchie", "Rasmus Lerdorf",
            "int number;", "float rate;", "int variable_count;", "int $main;",
            "LowerCase letters", "UpperCase letters", "CamelCase letters", "None of the mentioned",
            "stdlib. h", "ctype. h", "stdio. h", "stdarg. h",
            "int", "char *", "struct", "None of the mentioned",
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
        setContentView(R.layout.activity_question);
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
                    Toast.makeText(questionActivity.this, "Please select one choice ", Toast.LENGTH_SHORT).show();
                    return;

                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText( questionActivity.this, "Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText( questionActivity.this, "wrong", Toast.LENGTH_SHORT).show();
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
                        Questionnumber.setText(flag+ "/" +questions.length+" Question");
                    }
                    else {
                        marks=correct;
                        Intent in = new Intent( questionActivity.this,resultActivity.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),resultActivity.class);
                startActivity(intent1);
            }
        });


    }
}