package com.example.chinsk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static String SHARED_PREFS = "sharedPrefs";
    private static String SHARED_PREFS1 = "sharedPrefs1";
    private static String TEXT = "text";
    private static String TEXT1 = "text1";
    private static Random r = new Random();
    private static double li, wyn,licz;
    private static int l, l1, nr;
    private static String text, text1, k, k1;
    private static List<String> st1 = new ArrayList<>();
    private static List<String> st2 = new ArrayList<>();
    private static List<String> sth1 = new ArrayList<>();
    private static List<String> sth2;

    private static int setNumber() {
        nr = r.nextInt(st1.size());
        return nr;
    }
    private static int getNumber() {
        return nr;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save1 = findViewById(R.id.save);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sav();
            }
        });
    }
    public void sav() {
        licz++;
        loadData();
        if (licz<2&&st1.size()<2){st1.remove(0);st2.remove(0);}
        EditText t = findViewById(R.id.wpisz);
        EditText t1 = findViewById(R.id.Widok);
        try {
            String g = t1.getText().toString();
            sth1 = Arrays.asList(g.split(","));
            for (l = 0; l < sth1.size(); l++) {
                k = sth1.get(l);
                st1.add(k); }
            String h = t.getText().toString();
            sth2 = Arrays.asList(h.split(","));
            for (l1 = 0; l1 < sth2.size(); l1++) {
                k1 = sth2.get(l1);
                st2.add(k1); }
            /*Intent i = new Intent(MainActivity.this, Monit.class);
            i.putExtra("allst", stt1.toString() + stt2.toString());
            startActivity(i);*/
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(TEXT, String.valueOf((st1)));
            editor.apply();
            SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1, MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
            editor1.putString(TEXT1, String.valueOf((st2)));
            editor1.apply();
            li = 0;wyn = 0;
        } catch (UnsupportedOperationException e) {
            t.setText("Sejwujemy bezpośrednio po urochomieniu Apki! Sorki");
        } }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        st1 = new ArrayList<>(Arrays.asList(text.replace("[", "").replace("]", "")
                .replaceAll("\\s+", "").split(",")));
        //st1 = Arrays.asList(text.replace("[", "").replace("]", "").replaceAll("\\s+", "").split(","));
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1, MODE_PRIVATE);
        text1 = sharedPreferences1.getString(TEXT1, "");
        st2 = new ArrayList<>(Arrays.asList(text1.replace("[", "").replace("]", "")
                .replaceAll("\\s+", "").split(",")));
        //st2 = Arrays.asList(text1.replace("[", "").replace("]", "").replaceAll("\\s+", "").split(","));
    }
    public void reset(View f) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1, MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        sharedPreferences1.edit().clear().apply();
        loadData();
        licz=0;
    }
    public void nauczka(View f) {
        Intent i = new Intent(this, Nauk.class);
        startActivity(i);
    }
    public void brud(View f) {
        Intent i = new Intent(this, Vid.class);
        startActivity(i);
    }
   /* public void star(View v) {
        loadData();
        no.setNr(r.nextInt(st1.size()));
        TextView a = findViewById(R.id.Widok);
        int nr = no.getNr();
        a.setText(st1.get(nr));
    }*/
    public void spraw(View l) {
       try {
           li++;
        TextView a = findViewById(R.id.Widok);
        EditText t = findViewById(R.id.wpisz);
        loadData();
        if (li > 1) {
            String input = t.getText().toString();
            if (input.replaceAll("\\s+", "").equalsIgnoreCase(st2.get(MainActivity.getNumber()).replaceAll("\\s+", ""))) {
                wyn++;
                ImageView d = new ImageView(getApplicationContext());
                d.setImageResource(R.drawable.nymph);
                Toast t1 = new Toast(getApplicationContext());
                t1.setDuration(Toast.LENGTH_SHORT);
                t1.setView(d);
                t1.show();
                Toast.makeText(this, "Dobrze\nTwój wynik to " + wyn / (li - 1) * 100 + " procent", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Żle\nTwój wynik to " + wyn / (li - 1) * 100 + " procent", Toast.LENGTH_SHORT).show();
            /*setContentView(R.layout.activity_main);
            VideoView videoView = findViewById(R.id.vi1);
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.kot4;
            Uri uri = Uri.parse(videoPath);
            videoView.setVideoURI(uri);
            videoView.start();*/
            } }
        a.setText(st1.get(MainActivity.setNumber()));
    }catch(NullPointerException e){ EditText t = findViewById(R.id.wpisz);
           t.setText("Wprowadź pztania i odpowiedźi.");
    }}}
