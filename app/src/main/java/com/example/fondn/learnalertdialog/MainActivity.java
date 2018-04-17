package com.example.fondn.learnalertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button one,two,threeMCQ,fourRadio;
    ArrayList<Integer>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.oneButton);
        two = (Button) findViewById(R.id.twoButton);
        threeMCQ = (Button) findViewById(R.id.threeMCQButton);
        fourRadio = (Button) findViewById(R.id.forRadioButton);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Want to Delete?")
                        .setMessage("This file Going to Delete.")
                        .setCancelable(false)
                        .setPositiveButton("ok Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        })
                        .show();

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = {"sagor","noman","Shanta","Sabuj"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select One From Here");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You choose : "+items[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });


        threeMCQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = new ArrayList<Integer>();
                final String[] items = {"sagor","noman","Shanta","Sabuj"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select by MCQ");
                builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        arrayList.add(which);
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectIndex = "";
                        for (Integer i : arrayList){
                            selectIndex +=i+" ";
                        }
                        Toast.makeText(MainActivity.this, selectIndex, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });


        fourRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = {"sagor","noman","Shanta","Sabuj"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select From Radio");
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You Select :"+which , Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });

    }
}
