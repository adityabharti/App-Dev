package com.example.adityabharti.sqlitesample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText adityasInput;
    TextView adityasText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adityasInput = (EditText) findViewById(R.id.adityasInput);
        adityasText = (TextView) findViewById(R.id.adityasText);

        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void addButtonClicked(View view){
        Products product = new Products(adityasInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    public void deleteButtonClicked(View view){
        String inputText = adityasInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        adityasText.setText(dbString);
        adityasInput.setText("");
    }

}
