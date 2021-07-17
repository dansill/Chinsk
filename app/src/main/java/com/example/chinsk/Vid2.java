package com.example.chinsk;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Vid2 extends AppCompatActivity {
    public static final String SHARED_PRE11 = "sharedPre11";
    public static final String TEKST11 = "tekst11";
    private String tekst11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid);

        Button save1 = findViewById(R.id.bu);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savi();
            }
        });
        loadData();
        updateViews();
    }

    public void savi() {
        TextView t1 = findViewById(R.id.ed);
        t1.setText(t1.getText().toString());
        SharedPreferences share = getSharedPreferences(SHARED_PRE11, MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString(TEKST11, t1.getText().toString());
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PRE11, MODE_PRIVATE);
        tekst11 = sharedPreferences1.getString(TEKST11, "");
    }
    public void updateViews() {
        TextView t1 = findViewById(R.id.ed);
        t1.setText(tekst11);
    }
}






