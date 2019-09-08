package com.example.quizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mKeyStroke,mTouch,mWalk,mTest;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTouch = (Button) findViewById(R.id.game1);
        mTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touchActivity();
            }
        });
        mKeyStroke = (Button) findViewById(R.id.game2);
        mKeyStroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyStrokeActivity();
            }
        });
        mWalk = (Button) findViewById(R.id.game3);
        mWalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                walkActivity();
            }
        });
    }
    public void touchActivity(){
        Intent i = new Intent(this,Touch.class);
        i.putExtra("Touch","touch");
        startActivity(i);
    }
    public void keyStrokeActivity(){
        Intent i = new Intent(this, Keystroke.class);
        i.putExtra("Keystroke","maths");
        startActivity(i);
    }
    public void walkActivity(){
        Intent i = new Intent(this, Walk.class);
        i.putExtra("Walk","walk");
        startActivity(i);
    }
}
