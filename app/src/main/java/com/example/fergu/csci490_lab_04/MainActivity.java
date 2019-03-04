package com.example.fergu.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nice("https://jsonplaceholder.typicode.com/users");

    }

    public String nice(String val){
        URL url = null;
        try {
            url = new URL(val);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;


        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int i = 0;
        while(i < 20){
            try {
                line += bufferedReader.readLine();
                Log.i("hello",line);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
        return line;

    }

}
