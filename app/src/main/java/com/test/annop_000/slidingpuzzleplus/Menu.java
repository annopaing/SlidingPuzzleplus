package com.test.annop_000.slidingpuzzleplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    private ImageButton start;
    private ImageButton score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        start = (ImageButton)findViewById(R.id.start);
        start.setOnClickListener(this);
        score = (ImageButton)findViewById(R.id.score);
        score.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == start){
            Intent gotoplay = new Intent(getApplicationContext(), MainActivity.class);
            gotoplay.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(gotoplay);
        }else if (v == score){
            Intent gotoscore = new Intent(getApplicationContext(), Score.class);
            gotoscore.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(gotoscore);
        }

    }
}
