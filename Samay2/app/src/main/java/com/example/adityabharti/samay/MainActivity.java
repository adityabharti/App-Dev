package com.example.adityabharti.samay;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int t=1;
    Button startChrono;
    Button pauseChrono;
    Button resetChrono;
    Chronometer chrono;
    EditText timeText;
    String default_time = "00:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Time is runnin");

        startChrono = (Button) findViewById(R.id.button3);
        resetChrono = (Button) findViewById(R.id.button4);
        chrono = (Chronometer) findViewById(R.id.chronometer);


        startChrono.setOnClickListener(this);
        resetChrono.setOnClickListener(this);
        chrono.setText(default_time);
        //chrono.setTextColor(Color.GREEN);
        System.out.println(SystemClock.elapsedRealtime());
    }

    public void setTime(View view){
        chrono.stop();

        startChrono.setText("START");
        t=1;
        chrono.setTextColor(Color.BLUE);

        EditText editText = (EditText) findViewById(R.id.editText);
        String msg = editText.getText().toString();
        default_time = msg;
        chrono.setText(default_time);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View arg0){
        switch (arg0.getId()){

            case R.id.button3:
                if(t==1){
                    startChrono.setText("PAUSE");
                    t=0;
                int stoppedMilliseconds = 0;
                String chronoText = chrono.getText().toString();
                System.out.println("chronoText is --->" + chronoText);
                String array[] = chronoText.split(":");

                if(array.length==2){
                    stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) *1000;
                }
                else if(array.length==3){
                    stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000 + Integer.parseInt(array[2]) * 1000;
                }

                    chrono.setTextColor(Color.BLUE);
                chrono.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
                chrono.start();

                }
                else if(t==0) {
                    startChrono.setText("START");
                    chrono.setTextColor(Color.RED);
                    t=1;
                    chrono.stop();

                }

                break;

            case R.id.button4:
                chrono.stop();
                startChrono.setText("START");
                t=1;
                chrono.setTextColor(Color.BLUE);
                int stoppedMilliseconds1 = 0;
                String chronoText1 = "00:00";
                System.out.println("chronoText is --->" + chronoText1);
                String array1[] = chronoText1.split(":");

                if(array1.length==2){
                    stoppedMilliseconds1 = Integer.parseInt(array1[0]) * 60 * 1000 + Integer.parseInt(array1[1]) *1000;
                }
                else if(array1.length==3){
                    stoppedMilliseconds1 = Integer.parseInt(array1[0]) * 60 * 60 * 1000 + Integer.parseInt(array1[1]) * 60 * 1000 + Integer.parseInt(array1[2]) * 1000;
                }


                chrono.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds1);
                chrono.setText(default_time);
                break;


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}




