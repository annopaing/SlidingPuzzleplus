package com.test.annop_000.slidingpuzzleplus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView zero;
    private Chronometer stopwatch;
    private ArrayList<String> number;
    private ArrayList<String> checknumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (TextView)findViewById(R.id.one);
        one.setOnTouchListener(this);
        two = (TextView)findViewById(R.id.two);
        two.setOnTouchListener(this);
        three = (TextView)findViewById(R.id.three);
        three.setOnTouchListener(this);
        four = (TextView)findViewById(R.id.four);
        four.setOnTouchListener(this);
        five = (TextView)findViewById(R.id.five);
        five.setOnTouchListener(this);
        six = (TextView)findViewById(R.id.six);
        six.setOnTouchListener(this);
        seven = (TextView)findViewById(R.id.seven);
        seven.setOnTouchListener(this);
        eight = (TextView)findViewById(R.id.eight);
        eight.setOnTouchListener(this);
        zero = (TextView)findViewById(R.id.zero);
        zero.setOnTouchListener(this);
        createNumber();
        stopwatch = (Chronometer)findViewById(R.id.chronometer);
        stopwatch.setBase(SystemClock.elapsedRealtime());
        stopwatch.start();
    }


    public void randomNumber(int n){
        Random r = new Random();
        int randomnumtwopoint = r.nextInt(2);
        int randomnumthreepoint = r.nextInt(3);
        int randomnumfourpoint = r.nextInt(4);
        if(n ==0){
            if(randomnumtwopoint == 0){
                number.set(0, number.get(1));
                number.set(1, "0");
            }else if (randomnumtwopoint == 1){
                number.set(0, number.get(3));
                number.set(3, "0");
            }
        }else if (n == 1){
            if (randomnumthreepoint == 0) {
                number.set(1, number.get(0));
                number.set(0,"0");
            }else if(randomnumthreepoint == 1) {
                number.set(1, number.get(2));
                number.set(2,"0");
            }else if(randomnumthreepoint == 2) {
                number.set(1, number.get(4));
                number.set(4,"0");
            }
        } else if (n == 2){
            if(randomnumtwopoint == 0) {
                number.set(2, number.get(1));
                number.set(1,"0");
            }else if (randomnumtwopoint == 1) {
                number.set(2, number.get(5));
                number.set(5,"0");
            }
        }else if (n == 3){
            if (randomnumthreepoint == 0) {
                number.set(3,number.get(0));
                number.set(0,"0");
            }else if(randomnumthreepoint == 1) {
                number.set(3, number.get(4));
                number.set(4,"0");
            }else if(randomnumthreepoint == 2) {
                number.set(3, number.get(6));
                number.set(6,"0");
            }
        }else if (n == 4){
            if(randomnumfourpoint == 0) {
                number.set(4, number.get(1));
                number.set(1,"0");
            }else if(randomnumfourpoint == 1) {
                number.set(4, number.get(3));
                number.set(3,"0");
            }else if(randomnumfourpoint == 2) {
                number.set(4, number.get(5));
                number.set(5,"0");
            }else if(randomnumfourpoint == 3) {
                number.set(4, number.get(7));
                number.set(7,"0");
            }
        }else if (n == 5){
            if (randomnumthreepoint == 0) {
                number.set(5, number.get(2));
                number.set(2,"0");
            }else if(randomnumthreepoint == 1) {
                number.set(5, number.get(4));
                number.set(4,"0");
            }else if(randomnumthreepoint == 2) {
                number.set(5, number.get(8));
                number.set(8,"0");
            }
        }else if (n == 6){
            if(randomnumtwopoint == 0) {
                number.set(6, number.get(3));
                number.set(3,"0");
            }else if(randomnumtwopoint == 1) {
                number.set(6, number.get(7));
                number.set(7,"0");
            }
        }else if (n == 7){
            if (randomnumthreepoint == 0) {

                number.set(7, number.get(4));
                number.set(4,"0");
            }else if(randomnumthreepoint == 1) {

                number.set(7, number.get(6));
                number.set(6,"0");
            }else if(randomnumthreepoint == 2) {

                number.set(7, number.get(8));
                number.set(8,"0");
            }
        }else if (n == 8){
            if(randomnumtwopoint == 0) {

                number.set(8, number.get(5));
                number.set(5,"0");
            }else if(randomnumtwopoint == 1) {

                number.set(8, number.get(7));
                number.set(7,"0");
            }
        }
    }

    public void createNumber(){
        number = new ArrayList<String>();
        number.add(0, "1");
        number.add(1, "2");
        number.add(2, "3");
        number.add(3, "4");
        number.add(4, "5");
        number.add(5, "6");
        number.add(6, "7");
        number.add(7, "8");
        number.add(8, "0");
        checknumber = new ArrayList<String>();
        checknumber.addAll(number);
        for (int i=0;i<60;i++){
            for (int j=0;j<number.size();j++){
                if(number.get(j).equals("0")){
                    randomNumber(j);
                    break;
                }
            }
        }
        setNumber();
    }

    public void setNumber(){
        one.setText(number.get(0));
        one.setBackgroundColor(Color.RED);
        two.setText(number.get(1));
        two.setBackgroundColor(Color.BLUE);
        three.setText(number.get(2));
        three.setBackgroundColor(Color.CYAN);
        four.setText(number.get(3));
        four.setBackgroundColor(Color.DKGRAY);
        five.setText(number.get(4));
        five.setBackgroundColor(Color.GRAY);
        six.setText(number.get(5));
        six.setBackgroundColor(Color.GREEN);
        seven.setText(number.get(6));
        seven.setBackgroundColor(Color.MAGENTA);
        eight.setText(number.get(7));
        eight.setBackgroundColor(Color.YELLOW);
        zero.setText(number.get(8));
        zero.setBackgroundColor(Color.LTGRAY);
        if(number.get(0).equals("0")){
            one.setText("");
            one.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(1).equals("0")){
            two.setText("");
            two.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(2).equals("0")){
            three.setText("");
            three.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(3).equals("0")){
            four.setText("");
            four.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(4).equals("0")){
            five.setText("");
            five.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(5).equals("0")){
            six.setText("");
            six.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(6).equals("0")){
            seven.setText("");
            seven.setBackgroundColor(Color.TRANSPARENT);
        }else if(number.get(7).equals("0")){
            eight.setText("");
            eight.setBackgroundColor(Color.TRANSPARENT);
        }
        else if(number.get(8).equals("0")){
            zero.setText("");
            zero.setBackgroundColor(Color.TRANSPARENT);
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == one){
            if(number.get(1).equals("0")){
                number.set(1, number.get(0));
                number.set(0, "0");

            }else if (number.get(3).equals("0")){
                number.set(3, number.get(0));
                number.set(0, "0");

            }

        }else if (v == two){
            if (number.get(0).equals("0")) {
                number.set(0,number.get(1));
                number.set(1, "0");

            }else if(number.get(2).equals("0")) {
                number.set(2,number.get(1));
                number.set(1, "0");

            }else if(number.get(4).equals("0")) {
                number.set(4,number.get(1));
                number.set(1, "0");

            }
        } else if (v == three){
            if(number.get(1).equals("0")) {
                number.set(1,number.get(2));
                number.set(2, "0");

            }else if (number.get(5).equals("0")) {
                number.set(5,number.get(2));
                number.set(2, "0");

            }
        }else if (v == four){
            if (number.get(0).equals("0")) {
                number.set(0,number.get(3));
                number.set(3,"0");

            }else if(number.get(4).equals("0")) {
                number.set(4,number.get(3));
                number.set(3, "0");

            }else if(number.get(6).equals("0")) {
                number.set(6,number.get(3));
                number.set(3, "0");
            }
        }else if (v == five){
            if(number.get(1).equals("0")) {
                number.set(1,number.get(4));
                number.set(4, "0");
            }else if(number.get(3).equals("0")) {
                number.set(3,number.get(4));
                number.set(4, "0");
            }else if(number.get(5).equals("0")) {
                number.set(5,number.get(4));
                number.set(4, "0");
            }else if(number.get(7).equals("0")) {
                number.set(7,number.get(4));
                number.set(4, "0");
            }
        }else if (v == six){
            if (number.get(2).equals("0")) {
                number.set(2,number.get(5));
                number.set(5, "0");
            }else if(number.get(4).equals("0")) {
                number.set(4,number.get(5));
                number.set(5, "0");
            }else if(number.get(8).equals("0")) {
                number.set(8,number.get(5));
                number.set(5, "0");
            }
        }else if (v == seven){
            if(number.get(3).equals("0")) {
                number.set(3,number.get(6));
                number.set(6, "0");
            }else if(number.get(7).equals("0")) {
                number.set(7,number.get(6));
                number.set(6, "0");
            }
        }else if (v == eight){
            if (number.get(4).equals("0")) {
                number.set(4,number.get(7));
                number.set(7, "0");
            }else if(number.get(6).equals("0")) {
                number.set(6,number.get(7));
                number.set(7, "0");
            }else if(number.get(8).equals("0")) {
                number.set(8,number.get(7));
                number.set(7, "0");
            }
        }else if (v == zero){
            if(number.get(5).equals("0")) {
                number.set(5,number.get(8));
                number.set(8, "0");
            }else if(number.get(7).equals("0")) {
                number.set(7,number.get(8));
                number.set(8, "0");
            }
        }
        setNumber();
        if(String.valueOf(number).equals(String.valueOf(checknumber))){
            Intent gotofinish = new Intent(getApplicationContext(), finish.class);
            gotofinish.putExtra("time", stopwatch.getText());
            gotofinish.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            stopwatch.stop();
            startActivity(gotofinish);

        }
        return false;
    }
    public void onBackPressed() {
        Intent gotomenu = new Intent(getApplicationContext(), Menu.class);
        gotomenu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(gotomenu);
    }
}
