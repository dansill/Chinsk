package com.example.chinsk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Nauk extends AppCompatActivity {
    public static String SHARED_PREFS = "sharedPrefs";
    private static String TEXT = "text";
    private String text;
    public static String SHARED_PREFS1 = "sharedPrefs1";
    private static String TEXT1 = "text1";
    private String text1;
    int l, l1;
    String k,k1;
    List<String> stt1 = new ArrayList<>();
    List<String> stt2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nauk);
        loadData();
        updateViews();
    }
    public void nauczk(View f) {
        Intent i = new Intent(this, Vid.class);
        startActivity(i);
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1, MODE_PRIVATE);
        text1 = sharedPreferences1.getString(TEXT1, "");
    }
    public void updateViews() {
        TextView t = findViewById(R.id.nau);
        String g = text;
        List<String> sth1 = new ArrayList<>(Arrays.asList(g.split(",")));
        for (l = 0; l < sth1.size(); l++) {
            k = sth1.get(l);
            stt1.add(l + 1 + "." + k);
        }
        String h = text1;
        List<String> sth2 = new ArrayList<>(Arrays.asList(h.split(",")));
        for (l1 = 0; l1 < sth2.size(); l1++) {
            k1 = sth2.get(l1);
            stt2.add(l1 + 1 + "." + k1);
        }
        t.setText(stt1.toString().replace("[", "").replace("]", "") + "\n"
                + stt2.toString().replace("[", "").replace("]", ""));
    }
}






