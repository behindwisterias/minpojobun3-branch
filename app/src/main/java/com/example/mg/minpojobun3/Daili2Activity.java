package com.example.mg.minpojobun3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Daili2Activity extends AppCompatActivity {

    //110条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daili2);

        // text_view： activity_main.xml の TextView の id
        TextView textView = findViewById(R.id.text_view12);

        // テキストを設定
        // R.string.textは"Test TextView"のこと
        textView.setText(R.string.text_view12);

        // FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab12);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Daili3Activity.class);
                startActivity(intent);

            }
        });





    }
}
