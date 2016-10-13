package com.example.matilda.tddd13lab3;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Matilda on 2016-10-13.
 */
public class InteractiveSearcher extends EditText{

    private int id;

    public InteractiveSearcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        id = 0;

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //nothing to change
            }

            @Override
            public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {
                setBackgroundColor(Color.RED);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String searchString = charSequence.toString();
                        Log.d("Thread", searchString);
                        Connection con = new Connection();

                        try {
                            con.makeConnection(id, searchString);
                        } catch (IOException e) {
                            e.printStackTrace();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
                id++;

            }

            @Override
            public void afterTextChanged(final Editable editable) {


            }
        });
    }

    public InteractiveSearcher(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    public InteractiveSearcher(Context context){
        super(context);

    }
}
