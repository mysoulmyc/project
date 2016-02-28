package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/*
 * Created by Toshiba on 27/2/2559.
 */
public class Fragment3_Answer extends Activity {

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3_answer);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get button
        bt = (Button) findViewById(R.id.button_score);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Fragment5_scroe.class);
                startActivity(i);
            }
        });

//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score)
        {
            case 0: t.setText("Bad");
            case 1:
            case 2: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 3:
            case 4:t.setText("Hmmmm.. Someone's been reading a lot of trivia");
                break;
            case 5:t.setText("Who are you? A trivia wizard???");
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
