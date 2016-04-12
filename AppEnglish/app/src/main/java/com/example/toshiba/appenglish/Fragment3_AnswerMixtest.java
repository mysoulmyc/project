package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 * Created by Toshiba on 27/2/2559.
 */
public class Fragment3_AnswerMixtest extends Activity {

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3_answer);
////////get text view
        TextView t = (TextView) findViewById(R.id.textResult);
        TextView t2 = (TextView) findViewById(R.id.textView2);
////////get button
        bt = (Button) findViewById(R.id.button_score);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

////////////////get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

//////////////display score
        switch (score) {
            case 0:
                t.setText("Your score : " + score + "\n" + "Bad");
                break;
            case 1:
                t.setText("Your score : " + score + "\n" + "Not good");
                break;
            case 2:
                t.setText("Your score : " + score + "\n" + "Try again");
                break;
            case 3:
                t.setText("Your score : " + score + "\n" + "Don't Give up!");
                break;
            case 4:
                t.setText("Your score : " + score + "\n" + "Good job");
                break;
            case 5:
                t.setText("Your score : " + score + "\n" + "Excellent!!");
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
