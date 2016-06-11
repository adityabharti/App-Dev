package com.example.adityabharti.functionality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends AppCompatActivity {
   // TextView dispText = (TextView) findViewById(R.id.textView);

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        TextView dispText = (TextView) findViewById(R.id.textView);
        EditText findText = (EditText) findViewById(R.id.findWord);
        EditText repText = (EditText) findViewById(R.id.repWord);

        String textToFind = findText.getText().toString();
        String textToReplace = repText.getText().toString();

        String textToSearch = dispText.getText().toString();


    }

    public void displayMsg(View view){
        EditText enterText = (EditText) findViewById(R.id.editText2);
        TextView dispText = (TextView) findViewById(R.id.textView);

        dispText.setText(enterText.getText());
    }
    public void findMsg(View view) {
        TextView dispText = (TextView) findViewById(R.id.textView);
        EditText findText = (EditText) findViewById(R.id.findWord);

        String textToFind = findText.getText().toString();
        String textToSearch = dispText.getText().toString();

        if (textToSearch.contains(textToFind)) {
            Toast toast = Toast.makeText(this, "FOUND:" + textToFind, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "NOT FOUND:" + textToFind, Toast.LENGTH_SHORT);
            toast.show();
        }
    }


        public void replaceMsg(View view){
        TextView dispText = (TextView) findViewById(R.id.textView);
        EditText findText = (EditText) findViewById(R.id.findWord);
        EditText repText = (EditText) findViewById(R.id.repWord);

        String textToFind = findText.getText().toString();
        String textToReplace = repText.getText().toString();
        String textToSearch = dispText.getText().toString();

        if(textToSearch.contains(textToFind)){
            String replaced = textToSearch.replaceAll(textToFind,textToReplace);
            dispText.setText(replaced);
            notification.setSmallIcon(R.mipmap.ic_launcher);
            notification.setTicker("button clicked");
            notification.setWhen(System.currentTimeMillis());
            notification.setContentTitle("Choose Event");
            notification.setContentText("Alert....Text modified");

            Intent intent = new Intent(this, dialogActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);

            //Builds notification and issues it
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(uniqueID, notification.build());
        }
    }




}
