package com.example.mg.minpojobun3;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Saimufuriko2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saimufuriko2);



        // text_view： activity_main.xml の TextView の id
        TextView textView = findViewById(R.id.text_view42);

        // テキストを設定
        // R.string.textは"Test TextView"のこと
        textView.setText(R.string.text_view42);

        // FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab42);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Saimufuriko3Activity.class);
                startActivity(intent);

            }
        });






    }
}
