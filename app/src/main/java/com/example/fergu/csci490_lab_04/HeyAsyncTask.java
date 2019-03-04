package com.example.fergu.csci490_lab_04;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HeyAsyncTask extends AsyncTask<String, Void, String> {

    private TextView textView;

    public HeyAsyncTask(TextView textView) {
        this.textView = textView;
    }


    @Override
    protected String doInBackground(String... strings) {

        URL url = null;
        try {
            url = new URL(strings[0]);
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

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText((CharSequence)s.substring(29,40));

    }

}
