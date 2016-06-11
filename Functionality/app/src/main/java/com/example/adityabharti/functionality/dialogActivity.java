package com.example.adityabharti.functionality;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class dialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        /*

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("fire", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast toast =  Toast.makeText(this,"enter a text here",Toast.LENGTH_SHORT).show();
            }
        })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }

                    );
                    // Create the AlertDialog object and return it
                    return builder.create();
                }
    */


    }
}
