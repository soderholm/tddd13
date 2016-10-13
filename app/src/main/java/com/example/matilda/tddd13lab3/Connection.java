package com.example.matilda.tddd13lab3;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Matilda on 2016-10-13.
 */
public class Connection {
    JSONArray jsonArray;
    public void makeConnection (int id, String search) throws IOException, JSONException {
        URL url = new URL("http://flask-afteach.rhcloud.com/getnames/"+id+"/"+ search);
        URLConnection urlCon = url.openConnection();
        InputStream inputStream =urlCon.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        jsonArray = new JSONArray(br.readLine());

    }

    public Object results() throws JSONException {
        Log.d("Array", jsonArray.get(1).toString());
        return jsonArray.get(1);
    }
}
