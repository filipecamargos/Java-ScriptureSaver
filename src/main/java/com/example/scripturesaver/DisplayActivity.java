package com.example.scripturesaver;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    public static final String _BOOK = "BookValue";
    public static final String _CHAPTER = "ChapterValue";
    public static final String _VERSE = "VerseValue";

    public static final String TAG = "Log message to the second activity onCreat.";
    public static final String TAG1 = "Save Info was Called.";

    private String book;
    private String chapter;
    private String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Log Message
        Log.i(TAG, "Received intent with John 3:16");

        //Get the intent
        Intent intent = getIntent();
        book = intent.getStringExtra(_BOOK);
        chapter = intent.getStringExtra(_CHAPTER);
        verse = intent.getStringExtra(_VERSE);

        //Final scripture
        String scripture = book + " " + chapter + ":" + verse;

        //Set the view
        TextView scriptureView = findViewById(R.id.Scripture);
        scriptureView.setText(scripture);

        }

        public void saveInfo(View view) {
            Log.i(TAG1, "Save Info");

            SharedPreferences mPreferences = getSharedPreferences("com.example.scripturesave", MODE_PRIVATE);

            SharedPreferences.Editor prefEditor = mPreferences.edit();

            prefEditor.putString(_BOOK, book);
            prefEditor.putString(_CHAPTER, chapter);
            prefEditor.putString(_VERSE, verse);

            prefEditor.apply();

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Scripture Saved",
                    Toast.LENGTH_SHORT);
            toast.show();


        }

}

