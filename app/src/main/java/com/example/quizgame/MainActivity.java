package com.example.quizgame;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    String  USER_INFO = "UserInfo";
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

        showDialog();

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

    private void writeUserName(String strName) {
        SharedPreferences sp = getSharedPreferences(USER_INFO, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("username", strName);

        editor.apply();
    }

    private String readUserName() {
        SharedPreferences sp = getSharedPreferences(USER_INFO, MODE_PRIVATE);
        return sp.getString("username", null);
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_username);
        dialog.setCancelable(false);

        Button btnConfirm = dialog.findViewById(R.id.btn_confirm);
        final EditText txtName = dialog.findViewById(R.id.user_name);
        RadioButton radioPrev = dialog.findViewById(R.id.radio_prev);
        final RadioButton radioNew = dialog.findViewById(R.id.radio_new);

        final String userName = readUserName();
        if (userName == null) {
            dialog.findViewById(R.id.layout_ask).setVisibility(View.GONE);
        }

        radioNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setEnabled(true);
            }
        });

        radioPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName.setEnabled(false);
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioNew.isChecked() || userName == null) {
                    writeUserName(txtName.getText().toString());
                }
                dialog.dismiss();
            }
        });

        dialog.show();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout((2 * width)/3, ActionBar.LayoutParams.WRAP_CONTENT);
    }
}
