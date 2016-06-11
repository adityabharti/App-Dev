package com.example.adityabharti.moksh;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SpinnerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public String q1,q2,q3;
    public static int x=0;
    public final static String EXTRA_MESSAGE = "com.example.adityabharti.moksh.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this); // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        System.out.println("Spinnnnnnnnnnnnnnnnnner 1 created");


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        spinner2.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        System.out.println("Spinnnnnnnnnnnnnnnnnner 2 created");



        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        spinner3.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner3.setAdapter(adapter2);
        System.out.println("Spinnnnnnnnnnnnnnnnnner 3 created");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        switch (parent.getId()){
            case R.id.spinner:
                q1 = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner2:
                q2 = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinner3:
                q3 = parent.getItemAtPosition(position).toString();
                break;
            default:
                break;
        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
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

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);


        EditText editText = (EditText) findViewById(R.id.user_name);
        EditText editText2 = (EditText) findViewById(R.id.roll_no);

        String msg = editText.getText().toString();
        String msg1 = editText2.getText().toString();

        String msg2 = q1;
        int a = Integer.parseInt(q1);
        String msg3 = q2;
        int b = Integer.parseInt(q2);
        String msg4 = q3;
        int c = Integer.parseInt(q3);

        int tot = (50*a)+(100*b)+(200*c);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd  -hh:mm:ss");

        String str = sdf.format(new Date());
        intent.putExtra(EXTRA_MESSAGE, "\nTotal amount: "+tot+"/-\n"+"Customer Name: "+msg+"\nTable No.: " + msg1 + "\nIdli: "+ msg2 +"\nBiryani: "+msg3+"\nPizza: "+msg4+"\n"+str);
        startActivity(intent);
    }
}
