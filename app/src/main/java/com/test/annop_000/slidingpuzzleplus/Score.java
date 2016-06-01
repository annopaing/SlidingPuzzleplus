package com.test.annop_000.slidingpuzzleplus;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File scorefile = new File(path+"/score.txt");
        int row = 0;
        ArrayList<String> scorearray= new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(scorefile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String strLine = null;
            while((strLine = bufferedReader.readLine()) != null){
                scorearray.add(row,strLine);
                row++;
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        scorearray.set(scorearray.size()-1,"");
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this, R.layout.itemlist, scorearray);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(objAdapter);
    }

    public void onBackPressed() {
        Intent gotomenu = new Intent(getApplicationContext(), Menu.class);
        gotomenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(gotomenu);
    }
}
