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

public class questionActivity5 extends AppCompatActivity {

    String questions[] = {
            "1. What is the keyword used to define a class in Kotlin?",
            "2. Which of the following is not a valid way to create an object in Kotlin?",
            "3. What is the syntax for calling a method in Kotlin?",
            "4. What is the keyword used to define a singleton class in Kotlin?",
            "5. What is the keyword used to define an interface in Kotlin?",
            "6. What is the keyword used to define a sealed class in Kotlin?",
            "7. What is the keyword used to define an extension function in Kotlin",
            "8. What is the purpose of the object keyword in Kotlin?",
            "9.  What is a nested class in Kotlin?",
            "10. What is the keyword used to define a destructor in Kotlin?"

    };
    String answer[] = {
            "class",
            "Using the keyword instance",
            "object.method()",
            "object",
            "interface",
            "sealed",
            "fun",
            "To define a singleton object",
            "A class that is defined within another class",
            "finalize"
    };
    String opt[] = {
            "class","struct","object","type",
            "Using the keyword new","CUsing the keyword object","Using the keyword instance","Using the keyword val",
            "object.method()","object.function()","object.procedure()","object.call()",
            "singleton","object","static","final",
            "abstract","class","object","interface",
            "final","sealed","closed","restricted",
            "extend","fun","operator","infix",
            "To define a singleton object","To define a static class","To define a non-static class","To define an interface",
            "A class that is defined within another class","A class that is defined within a function","A class that is defined within a package","A class that is defined outside of any other class or function",
            "destructor","dispose","finalize","destroy"


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
        setContentView(R.layout.activity_question5);
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
                    Toast.makeText(questionActivity5.this, "Please select one choice ", Toast.LENGTH_SHORT).show();
                    return;

                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText( questionActivity5.this, "Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText( questionActivity5.this, "wrong", Toast.LENGTH_SHORT).show();
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
                        Intent in = new Intent( questionActivity5.this,resultActivity5.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),resultActivity5.class);
                startActivity(intent1);
            }
        });


    }
}