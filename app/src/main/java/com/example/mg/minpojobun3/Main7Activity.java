package com.example.mg.minpojobun3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {

    //94条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);



        // text_view： activity_main.xml の TextView の id
        TextView textView = findViewById(R.id.text_view4);

        // テキストを設定
        // R.string.textは"Test TextView"のこと
        textView.setText(R.string.text_view4);

        // FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Main8Activity.class);
                startActivity(intent);

            }
        });







    }
}
