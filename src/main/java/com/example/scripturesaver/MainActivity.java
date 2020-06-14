package com.example.scripturesaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    public static final String TAG = "Log message to the first activity's button handler.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendInfo(View view) {

        //Log Message
        Log.i(TAG, "About to create intent with John 3:16");

        //Create a new intent
        Intent intent = new Intent (this, DisplayActivity.class);

        //Get the info
        EditText book = (EditText) findViewById(R.id.Book);
        EditText chapter = (EditText) findViewById(R.id.Chapter);
        EditText verse = (EditText) findViewById(R.id.Verse);

        //Save the info into an array
        String bookInfo = book.getText().toString();
        String chapterInfo = chapter.getText().toString();
        String verseInfo = verse.getText().toString();

        intent.putExtra(DisplayActivity._BOOK, bookInfo);
        intent.putExtra(DisplayActivity._CHAPTER, chapterInfo);
        intent.putExtra(DisplayActivity._VERSE, verseInfo);
        startActivity(intent);


    }

    public void loadSavedInfo(View view) {
        SharedPreferences sharedPreRead = getSharedPreferences("com.example.scripturesave", MODE_PRIVATE);

        String _book = sharedPreRead.getString(DisplayActivity._BOOK, "");
        String _chapter = sharedPreRead.getString(DisplayActivity._CHAPTER, "0");
        String _verse = sharedPreRead.getString(DisplayActivity._VERSE, "0");

        TextView bookView = findViewById(R.id.Book);
        TextView chapterView = findViewById(R.id.Chapter);
        TextView verseView = findViewById(R.id.Verse);

        bookView.setText(_book);
        chapterView.setText(_chapter);
        verseView.setText(_verse);

    }
}
