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

public class questionActivity6 extends AppCompatActivity {

    String questions[] = {
            "1. Which of the following converts a type (integer or string type) to date-time structures in C#?",
            "2. Which of the following operator represents a conditional operation in C#?",
            "3. Which of the following access specifier in C# allows a child class to access the member variables and member functions of its base class?",
            "4. Which of the following preprocessor directive allows you to undefine a symbol in C#?",
            "5. Which of the following preprocessor directive allows generating a level one warning from a specific location in your code in C#?",
            "6. C# runs on the ___.",
            "7. C# programming language is used to develop -",
            "8. What is the extension of a C# language file?",
            "9. Who is the founder of C# programming language?",
            "10. SOAP in C# stands for ___."
    };
    String answer[] = {
            "ToDateTime",
            "?:",
            "Protected",
            "undef",
            "warning",
            ".NET Framework",
            "All of the above",
            ".cs",
            "Anders Hejlsberg",
            "Simple Object Access Protocol"
    };
    String opt[] = {
            "ToString","ToSingle","ToChar","ToDateTime",
            "?:","is","as","*",
            "Public","Private","Protected","Internal",
            "define","undef","region","endregion",
            "warning","region","line","error",
            ".NET Framework","Java Virtual Machine","Both A. and B.","None of the above",
            "Web apps","Desktop apps","Mobiles apps","All of the above",
            ".c",".cpp",".cs",".csp",
            "Anders Hejlsberg","Douglas Crockford","Rasmus Lerdorf","Brendan Eich",
            "Simple Object Access Protocol","Simple Object Access Program","Standard Object Access Protocol","Standard Object Access Program",
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
        setContentView(R.layout.activity_question6);
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
                    Toast.makeText(questionActivity6.this, "Please select one choice ", Toast.LENGTH_SHORT).show();
                    return;

                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText( questionActivity6.this, "Correct",Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText( questionActivity6.this, "wrong", Toast.LENGTH_SHORT).show();
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
                        Intent in = new Intent( questionActivity6.this,resultActivity6.class);
                        startActivity(in);
                    }
                    radio_g.clearCheck();
                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),resultActivity6.class);
                startActivity(intent1);
            }
        });


    }
}