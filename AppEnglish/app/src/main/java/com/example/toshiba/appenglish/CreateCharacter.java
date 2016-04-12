package com.example.toshiba.appenglish;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.toshiba.appenglish.DB.DatabaseAccess;

/**
 * Created by Toshiba on 12/4/2559.
 */
public class CreateCharacter extends Activity implements View.OnClickListener {

    Button create;
    RadioButton radioM, radioW;
    EditText editName;
    int sex;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout0_create_character);

        radioM = (RadioButton) findViewById(R.id.radioButtonM);
        radioW = (RadioButton) findViewById(R.id.radioButtonW);

        editName = (EditText) findViewById(R.id.username);

        create = (Button) findViewById(R.id.button_create);
        create.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        RadioGroup radioGroup = (RadioGroup) this.findViewById(R.id.radioGroup1);
        int radioCheckedId = radioGroup.getCheckedRadioButtonId();
        name = editName.getText().toString();

        switch (radioCheckedId) {
            case R.id.radioButtonM:
                CreateCharM();
                break;
            case R.id.radioButtonW:
                CreateCharW();
                break;
            case -1:
                AlertSelectSex();
                break;
        }

    }

    private void CreateCharM() {
        if (name.length() != 0) {
            sex = 1;
            setCreateCharacter();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        } else {
            AlertAddName();
        }
    }

    private void CreateCharW() {
        name = editName.getText().toString();
        if (name.length() != 0) {
            sex = 2;
            setCreateCharacter();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            finish();
        } else {
            AlertAddName();
        }
    }

    private void AlertAddName() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Error");
        dialog.setCancelable(true);
        dialog.setMessage(" โปรดใส่ชื่อตัวละครของคุณ ");

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    private void AlertSelectSex() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Error");
        dialog.setCancelable(true);
        dialog.setMessage(" โปรดเลือกเพศของตัวละคร ");

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    private void setCreateCharacter() {
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.createCharacter(name, sex, 1);
        Toast.makeText(this, "Create!", Toast.LENGTH_LONG).show();
        databaseAccess.close();
    }

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Exit");
        dialog.setCancelable(true);
        dialog.setMessage("Do you want to exit?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();

    }

}
