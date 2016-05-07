package com.mysoulmyc.android.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mysoulmyc.android.appenglish.DB.CharacterInfo;
import com.mysoulmyc.android.appenglish.DB.DatabaseAccess;
import com.mysoulmyc.android.appenglish.DB.Score;

/**
 * Created by Toshiba on 11/2/2559.
 */
public class StartActivity extends Activity implements View.OnClickListener {
    Button butstart;
    CharacterInfo character;
    Score preScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout0_start);

        butstart = (Button) findViewById(R.id.but_start);
        butstart.setOnClickListener(this);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        character = databaseAccess.getCharacter();
        preScore = databaseAccess.get_PreScore();
        databaseAccess.close();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.but_start) {
            if (character != null) {
                if (preScore != null) {
                    updateTime();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Log.d("Alert", "Null Pre-test");
                    Toast.makeText(this, " เริ่มทำแบบทดสอบ Pre-test อีกครั้ง ", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), PreTest.class);
                    startActivity(i);
                    finish();
                }
            } else {
                Intent i = new Intent(getApplicationContext(), CreateCharacter.class);
                startActivity(i);
                finish();
            }
        }
    }

    private void updateTime() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.updateTime(character);
        Toast.makeText(this, "Update date time!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }

}
