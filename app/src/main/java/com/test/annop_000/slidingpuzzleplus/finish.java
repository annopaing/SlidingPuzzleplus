package com.test.annop_000.slidingpuzzleplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class finish extends AppCompatActivity implements View.OnClickListener {
    private ImageButton confirm;
    private Bundle bundle;
    private TextView time;
    private EditText name;
    private int checknumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        time = (TextView) findViewById(R.id.time);
        name = (EditText) findViewById(R.id.editName);
        confirm = (ImageButton) this.findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        bundle = getIntent().getExtras();
        time.setText("Time " + bundle.getString("time"));
    }

    @Override
    public void onClick(View v) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File scorefile = new File(path + "/score.txt");
        if (v == confirm) {
            BufferedWriter writer = null;
            FileOutputStream fileOutputStream = null;
            ArrayList<String> timearray= new ArrayList<String>();
            int row = 0;
            try {
                FileInputStream fileInputStream = new FileInputStream(scorefile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String strLine = null;
                while ((strLine = bufferedReader.readLine()) != null) {
                    timearray.add(row, strLine);
                    row++;
                }
                Log.d(timearray.toString(),timearray.toString());
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                fileOutputStream = new FileOutputStream(scorefile);
                writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

                    ArrayList<String> buffertime = new ArrayList<String>();
                    String[] textsplit;
                    String[] buffertext;
                    String[] time = bundle.getString("time").split(":");
                    String timevalue = time[0] + time[1];
                    for (int i = 0; i < timearray.size(); i++) {
                        textsplit = timearray.get(i).split("   ");
                        buffertext = textsplit[1].split(":");
                        String s = buffertext[0] + buffertext[1];
                        buffertime.add(i, s);
                    }
                    int buffernumbertime = 0;
                    for (int i = 0; i < timearray.size(); i++) {
                        buffernumbertime = buffernumbertime + Integer.parseInt(buffertime.get(i).toString());
                        if (Integer.parseInt(timevalue.toString()) <= buffernumbertime) {
                            checknumber = i;
                            break;
                        }
                        buffernumbertime = 0;
                    }

                    int count;
                    if (row <= 10) {
                        count = row;
                    } else {
                        count = 10;
                    }
                    for (int i = 0; i < count; i++) {
                        if (checknumber == i) {
                            Log.w(name.toString(),timearray.toString());
                            writer.write(name.getText().toString() + "   " + bundle.getString("time") + "\n");
                        }
                        writer.write(timearray.get(i) + "\n");
                    }
                writer.close();
            } catch (java.io.IOException e1) {
                e1.printStackTrace();
            }
            Intent gotoscore = new Intent(getApplicationContext(), Score.class);
            gotoscore.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(gotoscore);
        }
    }

    public void onBackPressed() {
        Intent gotomenu = new Intent(getApplicationContext(), Menu.class);
        gotomenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(gotomenu);
    }
}
