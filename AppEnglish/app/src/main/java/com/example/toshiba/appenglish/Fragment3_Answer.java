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
//get rating bar object
        //RatingBar bar=(RatingBar)findViewById(R.id.ratingBar);
//get text view
        TextView t = (TextView) findViewById(R.id.textResult);
        imageView = (ImageView) findViewById(R.id.imageView3);

        //ListView ls = (ListView)findViewById(R.id.listView2);
        //TextView t2 = (TextView) findViewById(R.id.textView2);
        //get button
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
                imageView.setImageResource(R.drawable.bad);
                break;
            case 1:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.tagain);
                break;
            case 2:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.good);
                break;
            case 3:
                t.setText("Your score : " + score);
                imageView.setImageResource(R.drawable.excellent);
                break;
        }


//        mHelper = new DbHelper(this);
//        mDb = mHelper.getWritableDatabase();
//        String sql = "INSERT INTO Point (point) VALUES " + score ;
//        mDb.execSQL(sql);
//        Toast.makeText(getApplicationContext(), "Records Saved Successfully", Toast.LENGTH_LONG).show();
//        mDb.close();


        //String ans = b.getString("yourans");
        //t2.setText(ans);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(, android.R.layout.simple_list_item_1, ans);
        // ls.setAdapter(adapter);



        /*bt = (Button) findViewById(R.id.button_score);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
