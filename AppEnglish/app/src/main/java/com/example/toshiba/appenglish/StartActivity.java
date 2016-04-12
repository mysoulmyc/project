package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.toshiba.appenglish.DB.CharacterInfo;
import com.example.toshiba.appenglish.DB.DatabaseAccess;

/**
 * Created by Toshiba on 11/2/2559.
 */
public class StartActivity extends Activity implements View.OnClickListener {
    Button butstart;
    CharacterInfo character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout0_start);

        butstart = (Button) findViewById(R.id.but_start);
        butstart.setOnClickListener(this);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        character = databaseAccess.getCharacter();
        databaseAccess.close();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.but_start) {
            if (character != null) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(getApplicationContext(), CreateCharacter.class);
                startActivity(i);
                finish();
            }
        }
    }

}
