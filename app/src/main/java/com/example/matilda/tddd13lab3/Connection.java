package com.example.matilda.tddd13lab3;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Matilda on 2016-10-13.
 */
public class Connection {
    JSONObject jsonObject;
    public void makeConnection (int id, String search) throws IOException, JSONException {
        if (!search.isEmpty()) {

            URL url = new URL("http://flask-afteach.rhcloud.com/getnames/" + id + "/" + search);
            URLConnection urlCon = url.openConnection();
            InputStream inputStream = urlCon.getInputStream();


            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            jsonObject = new JSONObject(br.readLine());

        }

    }

    public Object results() throws JSONException {
        JSONArray array  = (JSONArray)jsonObject.get("result");
        //Log.d("PRINTA", array.get(0).toString());

        return array;
    }
}
