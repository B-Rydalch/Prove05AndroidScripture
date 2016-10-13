package com.example.bradrydalch.prove05androidscripture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by bradrydalch on 10/12/16.
 */

public class display extends Activity {

    String iBook;
    String iChapter;
    String iVerse;
//    MainActivity mainBook;
//    MainActivity mainChapter;
//    MainActivity mainVerse;
//    private TextView displayTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        TextView display = (TextView) findViewById(R.id.txtWidget);
        Bundle intent = getIntent().getExtras();
        iBook = intent.getString("book");
        iChapter = intent.getString("chapter");
        iVerse = intent.getString("verse");
       // iBook = intent.getStringExtra("book");
       // iChapter = intent.getStringExtra("chapter");
       // iVerse = intent.getStringExtra("verse");


        display.setText("Your favorite scripture is " + iBook + " " + iChapter + " : " + iVerse);

    }
}
