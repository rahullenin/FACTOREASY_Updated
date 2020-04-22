package com.example.factoreasy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    int streakCount = 0;
    int count;
    public int streakCounter(boolean r) {
        TextView txt = (TextView) findViewById(R.id.streakView);
        if (r) {
            int last;
            streakCount = streakCount + 1;
        } else {
            streakCount = 0;
        }

        return streakCount;
    }
    public void vibrate(){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }
  /*public void countDown() {
        new CountDownTimer(10000, 1000) {
            TextView textView = (TextView) findViewById(R.id.textView3);
            EditText editText = (EditText) findViewById(R.id.editText2);


            public void onTick(long millisUntilFinished) {

                display((int) (millisUntilFinished / 1000), true);
                Log.i("Seconds left", String.valueOf(millisUntilFinished / 1000));

            }

            public void onFinish() {
                Log.i("OOPS", "time up");
                Button bu1 = (Button) findViewById(R.id.button1);
                Button bu2 = (Button) findViewById(R.id.button2);
                Button bu3 = (Button) findViewById(R.id.button3);
                Button bu4 = (Button) findViewById(R.id.button4);

                bu4.animate().alpha(1);
                EditText ed1 = (EditText) findViewById(R.id.editText);
                ed1.setText("");
                editText.animate().alpha(0);
            }
        }.start();
    }


    public void display(long x,boolean y){
        if(y){
            TextView textView=(TextView)findViewById(R.id.textView3);
            EditText editText=(EditText)findViewById(R.id.editText2);
            textView.animate().alpha(1);
            editText.animate().alpha(1);
            editText.setText(String.valueOf(x));
            Log.i("Seconds left", String.valueOf(x / 1000));
        }
        else{
            EditText editText=(EditText)findViewById(R.id.editText2);
            editText.setText(Integer.toString(0));

        }

    }*/



    private int[] getFactors(Integer number) {
        int factorNumber = 1;
        int varArrayStoreID = 0;
        int[] factors = new int[20];

        while (factorNumber <= number) {
            if (number % factorNumber == 0) {
                varArrayStoreID = varArrayStoreID + 1;
                factors[varArrayStoreID] = factorNumber;
                Log.i("info", Integer.toString(factors[varArrayStoreID]));

            }
            factorNumber++;
        }

        return factors;
    }

    public boolean isPrime(int y) {
        boolean isPrime = true;
        for (int divisor = 2; divisor <= y / 2; divisor++) {
            if (y % divisor == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    int randomNumber;

    public int randomNumb(int x) {
        Random rand = new Random();
        randomNumber = rand.nextInt(x);
        return randomNumber;
    }
    public int[] getExc(int[] x,int[] y) {
        ArrayList l1 = new ArrayList();
        ArrayList l2 = new ArrayList();
        ArrayList l3 = new ArrayList();
        for (int i=0;i<x.length;i++) {
            l1.add(x[i]);
            Log.i("listttttt1",Integer.toString((Integer) l1.get(i)));
        }

        for (int i=0;i<y.length;i++) {
                l2.add(y[i]);
                Log.i("listttttt2",Integer.toString((Integer)l2.get(i)));
        }

        Log.i("size of listttttt2", Integer.toString(l2.size()));
        for (int k=0;k<l2.size();k++){
            int a= (int) l2.get(k);
            Log.i("selsected ele",Integer.toString((int) l2.get(k)));
            for(int j=0;j<l1.size();j++){
                if(((int)l1.get(j))==a){
                    l1.remove(j);
                }
            }
        }
        int[] nep =new int[1000];
        for (int i = 0; i < l1.size(); i++) {
            nep[i] = (int) l1.get(i);
        }
        return nep;
    }


    int rightpos;
    public  void factorize(View view) {

        EditText numbr = (EditText) findViewById(R.id.editText);
        if(numbr.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter a number.", Toast.LENGTH_SHORT).show();
        }else {
            int num = Integer.parseInt(numbr.getText().toString());
            String empty = numbr.getText().toString();
            Log.i("emptiness", empty);
            Log.i("Entered nmumber is", Integer.toString(num));
            ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.mainLayout);
            lay.setBackgroundResource(R.drawable.math);
            Button bu4 = (Button) findViewById(R.id.button4);
            bu4.animate().alpha(0).setDuration(500);
            boolean isPr = isPrime(num);
            if (num == 1) {
                Toast.makeText(this, "1 doesn't have a any factors except itself", Toast.LENGTH_LONG).show();
                Button bu1 = (Button) findViewById(R.id.button1);
                Button bu2 = (Button) findViewById(R.id.button2);
                Button bu3 = (Button) findViewById(R.id.button3);
                EditText ed1 = (EditText) findViewById(R.id.editText);
                bu1.animate().alpha(0).setDuration(2000);
                bu2.animate().alpha(0).setDuration(2000);
                bu3.animate().alpha(0).setDuration(2000);
                ed1.setText("");
                bu4.animate().alpha(1).setDuration(1000);
            } else if (num == 0) {
                Toast.makeText(this, "0 doesn't have any factor", Toast.LENGTH_LONG).show();
                Button bu1 = (Button) findViewById(R.id.button1);
                Button bu2 = (Button) findViewById(R.id.button2);
                Button bu3 = (Button) findViewById(R.id.button3);
                EditText ed1 = (EditText) findViewById(R.id.editText);
                bu1.animate().alpha(0).setDuration(2000);
                bu2.animate().alpha(0).setDuration(2000);
                bu3.animate().alpha(0).setDuration(2000);
                bu4.animate().alpha(1).setDuration(1000);

            } else if (!isPr) {

                if (num != 4) {
                    int[] factorz = getFactors(num);
                    Button button1 = (Button) findViewById(R.id.button1);
                    Button button2 = (Button) findViewById(R.id.button2);
                    Button button3 = (Button) findViewById(R.id.button3);
                    button1.animate().alpha(1).setDuration(300).rotation(360);
                    button2.animate().alpha(1).setDuration(300).rotation(360);
                    button3.animate().alpha(1).setDuration(300).rotation(360);
                    int[] ss = new int[num];
                    for (int i = 0; i < num; i++) {
                        ss[i] = i + 1;
                    }
                    int[] exc = getExc(ss, factorz);
                    int ele = 0;
                    while (factorz[ele] == 0) {
                        ele = randomNumb(factorz.length - 1);
                    }
                    int rightVal = factorz[ele];
                    int ele1 = 0;
                    while (exc[ele1] == 0 || exc[ele1] == rightVal) {
                        ele1 = randomNumb(exc.length - 1);
                    }
                    int wrng1 = exc[ele1];
                    int ele2 = 0;
                    while (exc[ele2] == 0 || exc[ele2] == wrng1 || exc[ele2] == rightVal) {
                        ele2 = randomNumb(exc.length - 1);
                    }
                    int wrng2 = exc[ele2];
                    rightpos = (int) (Math.random() * 3 + 1);
                    Log.i("rightpos", Integer.toString(rightpos));
                    Log.i("rightVal", Integer.toString(rightVal));
                    Log.i("wrng1", Integer.toString(wrng1));
                    Log.i("wrng2", Integer.toString(wrng2));
                    if (rightpos == 1) {
                        button1.setText(Integer.toString(rightVal));
                        button2.setText(Integer.toString(wrng1));
                        button3.setText(Integer.toString(wrng2));
                    } else if (rightpos == 2) {
                        button1.setText(Integer.toString(wrng1));
                        button2.setText(Integer.toString(rightVal));
                        button3.setText(Integer.toString(wrng2));
                    } else {
                        button1.setText(Integer.toString(wrng1));
                        button2.setText(Integer.toString(wrng2));
                        button3.setText(Integer.toString(rightVal));
                    }

                    // countDown();
                } else {
                    rightpos = 1;
                    Button button1 = (Button) findViewById(R.id.button1);
                    Button button2 = (Button) findViewById(R.id.button2);
                    Button button3 = (Button) findViewById(R.id.button3);
                    button1.animate().alpha(1).setDuration(300).rotation(360);
                    button2.animate().alpha(1).setDuration(300).rotation(360);
                    button3.animate().alpha(1).setDuration(300).rotation(360);
                    button1.setText(Integer.toString(4));
                    button2.setText(Integer.toString(3));
                    button3.setText(Integer.toString(0));
                }

            } else if (isPr) {
                Toast.makeText(this, Integer.toString(num) + " is a prime number", Toast.LENGTH_LONG).show();
                Button bu1 = (Button) findViewById(R.id.button1);
                Button bu2 = (Button) findViewById(R.id.button2);
                Button bu3 = (Button) findViewById(R.id.button3);
                EditText ed1 = (EditText) findViewById(R.id.editText);
                bu1.animate().alpha(0).setDuration(2000);
                bu2.animate().alpha(0).setDuration(2000);
                bu3.animate().alpha(0).setDuration(2000);
                ed1.setText("");
                bu4.animate().alpha(1).setDuration(1000);
            }

        }
    }


        @SuppressLint("ResourceAsColor")
        public void but1 (View view){

            Button bu4 = (Button) findViewById(R.id.button4);
            bu4.animate().alpha(1).setDuration(400);
            Button bu1 = (Button) findViewById(R.id.button1);
            Button bu2 = (Button) findViewById(R.id.button2);
            Button bu3 = (Button) findViewById(R.id.button3);
            EditText ed1 = (EditText) findViewById(R.id.editText);
            TextView textstr = (TextView) findViewById(R.id.streakView);
            ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.mainLayout);
            if (rightpos == 1) {
                bu1.setText("yayy!");
                bu1.animate().alpha(0).setDuration(2000);
                bu2.animate().alpha(0).setDuration(2000);
                bu3.animate().alpha(0).setDuration(2000);
                ed1.setText("");
                lay.setBackgroundResource(R.color.green);
                Log.i("button 1111111111", "workssssss");
                count = streakCounter(true);
                Log.i("streakcounttterrrrrrrrr", Integer.toString(count));
                textstr.setText(Integer.toString(count));
            } else {
                bu1.setText("Wrong");
                bu1.animate().alpha(0).setDuration(2000);
                bu2.animate().alpha(0).setDuration(2000);
                bu3.animate().alpha(0).setDuration(2000);
                ed1.setText("");
                Log.i("button 1111111111", "workssssss");
                count = streakCounter(false);
                Log.i("streakcounttterrrrrrrrr", Integer.toString(count));
                textstr.setText(Integer.toString(count));
                lay.setBackgroundResource(R.color.red);
                vibrate();

            }
        }




    public void but2(View view) {

        Button bu4 = (Button) findViewById(R.id.button4);
        bu4.animate().alpha(1).setDuration(400);
        Button bu1 = (Button) findViewById(R.id.button1);
        Button bu2 = (Button) findViewById(R.id.button2);
        Button bu3 = (Button) findViewById(R.id.button3);
        EditText ed1 = (EditText) findViewById(R.id.editText);
        TextView textstr = (TextView) findViewById(R.id.streakView);
        ConstraintLayout lay=(ConstraintLayout)findViewById(R.id.mainLayout);
        if (rightpos == 2) {
            bu2.setText("yayy!");
            bu1.animate().alpha(0).setDuration(2000);
            bu2.animate().alpha(0).setDuration(2000);
            bu3.animate().alpha(0).setDuration(2000);
            ed1.setText("");
            Log.i("button 1111111111", "workssssss");
            count = streakCounter(true);
            Log.i("streakcounttterrrrrrrrr", Integer.toString(count));
            textstr.setText(Integer.toString(count));
            lay.setBackgroundResource(R.color.green);


        } else {
            bu2.setText("Wrong");
            bu1.animate().alpha(0).setDuration(2000);
            bu2.animate().alpha(0).setDuration(2000);
            bu3.animate().alpha(0).setDuration(2000);
            ed1.setText("");
            Log.i("button 1111111111", "workssssss");
            count = streakCounter(false);
            Log.i("streakcounttterrrrrrrrr", Integer.toString(count));
            textstr.setText(Integer.toString(count));
            lay.setBackgroundResource(R.color.red);
            vibrate();
        }
    }


    public void but3(View view) {

        Button bu4 = (Button) findViewById(R.id.button4);
        bu4.animate().alpha(1).setDuration(400);
        Button bu1 = (Button) findViewById(R.id.button1);
        Button bu2 = (Button) findViewById(R.id.button2);
        Button bu3 = (Button) findViewById(R.id.button3);
        EditText ed1 = (EditText) findViewById(R.id.editText);
        TextView textstr = (TextView) findViewById(R.id.streakView);
        ConstraintLayout lay=(ConstraintLayout)findViewById(R.id.mainLayout);
        if (rightpos == 3) {
            bu3.setText("yayy!");
            bu1.animate().alpha(0).setDuration(2000);
            bu2.animate().alpha(0).setDuration(2000);
            bu3.animate().alpha(0).setDuration(2000);
            ed1.setText("");
            Log.i("button 1111111111", "workssssss");
            count = streakCounter(true);
            Log.i("streakcounttterrrrrrrrr", Integer.toString(count));
            textstr.setText(Integer.toString(count));
            lay.setBackgroundResource(R.color.green);
        } else {
            bu3.setText("Wrong");
            bu1.animate().alpha(0).setDuration(2000);
            bu2.animate().alpha(0).setDuration(2000);
            bu3.animate().alpha(0).setDuration(2000);
            ed1.setText("");
            Log.i("button 1111111111", "workssssss");
            count = streakCounter(false);
            Log.i("streakcounttterrrrrrrrr", Integer.toString(count));
            textstr.setText(Integer.toString(count));
            lay.setBackgroundResource(R.color.red);
            vibrate();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}