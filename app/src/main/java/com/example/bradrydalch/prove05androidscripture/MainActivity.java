package com.example.bradrydalch.prove05androidscripture;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String inputBook;
    private String inputChapter;
    private String inputVerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // handle book input
        EditText editTextBook = (EditText) findViewById(R.id.bookID);
        editTextBook.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent){
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_NEXT){
                    inputBook = textView.getText().toString();
                    Toast.makeText(MainActivity.this, "Your book is " + inputBook,Toast.LENGTH_SHORT).show();
                }
                return handled;
            }


        });

        // handle chapter input
        EditText editTextChapter = (EditText) findViewById(R.id.chapterID);
        editTextChapter.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent){
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_NEXT){
                    inputChapter = textView.getText().toString();
                    Toast.makeText(MainActivity.this, "Your chapter is " + inputChapter,Toast.LENGTH_SHORT).show();
                }
                return handled;
            }


        });

        // handle verse input
        EditText editTextVerse= (EditText) findViewById(R.id.verseID);
        editTextVerse.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent){
                boolean handled = false;
                if(i == EditorInfo.IME_ACTION_NEXT){
                    inputVerse = textView.getText().toString();
                    Toast.makeText(MainActivity.this, "Your verse is " + inputVerse,Toast.LENGTH_SHORT).show();

                    InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                    handled = true;

                }
                return handled;
            }

        });
    }

    // submit data to second activity
    public void submitted(View v){
        if (v.getId() == R.id.submitButton){
            Intent i = new Intent(MainActivity.this, display.class);
            i.putExtra("book",inputBook);
            i.putExtra("chapter", inputChapter);
            i.putExtra("verse",inputVerse);
            startActivity(i);
        }

    }

}
