package com.test.annop_000.slidingpuzzleplus;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File scorefile = new File(path+"/score.txt");
        CountDownTimer time = new CountDownTimer(3500, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                BufferedWriter writer = null;
                try {
                    FileInputStream fileInputStream = new FileInputStream(scorefile);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    Intent gotomenu = new Intent(getApplicationContext(), Menu.class);
                    gotomenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    startActivity(gotomenu);
                } catch (Exception e) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(scorefile);
                        writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                        writer.write("unknown   99:99");

                        writer.close();
                    } catch (java.io.IOException e1) {
                        e1.printStackTrace();
                    }
                    Intent gotomenu = new Intent(getApplicationContext(), Menu.class);
                    gotomenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(gotomenu);
                }
            }
        };time.start();
    }
}
