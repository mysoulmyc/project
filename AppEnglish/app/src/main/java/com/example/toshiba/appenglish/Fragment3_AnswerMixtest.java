package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * Created by Toshiba on 27/2/2559.
 */
public class Fragment3_AnswerMixtest extends Activity {

    Button bt;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3_answer);

        TextView t = (TextView) findViewById(R.id.textResult);
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

////////////////get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

//////////////display score
        switch (score) {
            case 0:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 1:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 2:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 3:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 4:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 5:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo1);
                break;
            case 6:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 7:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 8:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 9:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 10:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo2);
                break;
            case 11:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 12:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 13:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 14:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 15:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo3);
                break;
            case 16:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 17:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 18:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 19:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.emo4);
                break;
            case 20:
                t.setText("Your score : " + score);
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
