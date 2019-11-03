package com.may.shop;

import android.app.AlertDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private ImageView resultusername;
    private ImageView resultpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        find();
        result();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    private void find() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }
    private void result() {
        resultusername = findViewById(R.id.result_username);
        resultpassword = findViewById(R.id.result_password);
    }

    public void check(View view){

        if(username.length()<4){
            //resultusername.setAlpha(0.1f);
            resultusername.setVisibility(View.VISIBLE);
            resultusername.setImageResource(R.drawable.wrong);
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("Your name have to be larger than 4 letters")
                    .setPositiveButton("OK",null)
                    .show();

        }
        if (password.length()<6){
            //resultusername.setAlpha(0.1f);
            resultpassword.setVisibility(View.VISIBLE);
            resultpassword.setImageResource(R.drawable.wrong);
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("Your password have to be larger than 6 letters")
                    .setPositiveButton("ok",null)
                    .show();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
