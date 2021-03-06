package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toshiba.appenglish.DB.DbHelper;
import com.example.toshiba.appenglish.DB.Score;

/*
 * Created by Toshiba on 27/2/2559.
 */
public class Fragment3_Answer extends Activity {

    ImageView imageView;
    Button bt;
    SQLiteDatabase mDb;
    DbHelper mHelper;
    Score sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3_answer);

        TextView t = (TextView) findViewById(R.id.textResult);
        TextView showText = (TextView) findViewById(R.id.textResult2);
        imageView = (ImageView) findViewById(R.id.imageView3);
        bt = (Button) findViewById(R.id.button_score);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        //get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        //display score
        switch (score) {
            case 0:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 1:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 2:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 3:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 4:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 5:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 6:
                t.setText("Your score : " + score);
                showText.setText(R.string.testAgain);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 7:
                t.setText("Your score : " + score);
                showText.setText(R.string.testPass);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 8:
                t.setText("Your score : " + score);
                showText.setText(R.string.testPass);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 9:
                t.setText("Your score : " + score);
                showText.setText(R.string.testPass);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 10:
                t.setText("Your score : " + score);
                showText.setText(R.string.testPass);
                imageView.setImageResource(R.drawable.emo4);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
