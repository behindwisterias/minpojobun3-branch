package com.example.mg.minpojobun3;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundOne, soundTwo;
    private Button button1, button2, button3, button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Button sendButton = findViewById(R.id.button);
        //sendButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(getApplication(), Main2Activity.class);
        //        startActivity(intent);
        //    }
        //});



        //soundpool
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                // USAGE_MEDIA
                // USAGE_GAME
                .setUsage(AudioAttributes.USAGE_GAME)
                // CONTENT_TYPE_MUSIC
                // CONTENT_TYPE_SPEECH, etc.
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                // ストリーム数に応じて
                .setMaxStreams(2)
                .build();

        // decision4.wav をロードしておく
        soundOne = soundPool.load(this, R.raw.decision4, 1);


        // load が終わったか確認する場合
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d("debug","sampleId="+sampleId);
                Log.d("debug","status="+status);
            }
        });


        button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // one.wav の再生
                // play(ロードしたID, 左音量, 右音量, 優先度, ループ,再生速度)
                soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                // ボタンの回転アニメーション
                //RotateAnimation buttonRotation = new RotateAnimation(0, 360, button1.getWidth()/2, button1.getHeight()/2);
                //buttonRotation.setDuration(2000);
                //button1.startAnimation(buttonRotation);

                Intent intent = new Intent(getApplication(), Main2Activity.class);
                startActivity(intent);



            }
        });


        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // one.wav の再生
                // play(ロードしたID, 左音量, 右音量, 優先度, ループ,再生速度)
                soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                // ボタンの回転アニメーション
                //RotateAnimation buttonRotation = new RotateAnimation(0, 360, button1.getWidth()/2, button1.getHeight()/2);
                //buttonRotation.setDuration(2000);
                //button1.startAnimation(buttonRotation);

                Intent intent2 = new Intent(getApplication(), BukkenActivity.class);
                startActivity(intent2);



            }
        });


        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // one.wav の再生
                // play(ロードしたID, 左音量, 右音量, 優先度, ループ,再生速度)
                soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                // ボタンの回転アニメーション
                //RotateAnimation buttonRotation = new RotateAnimation(0, 360, button1.getWidth()/2, button1.getHeight()/2);
                //buttonRotation.setDuration(2000);
                //button1.startAnimation(buttonRotation);

                Intent intent3 = new Intent(getApplication(), SaikenActivity.class);
                startActivity(intent3);



            }
        });


        button5 = findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // one.wav の再生
                // play(ロードしたID, 左音量, 右音量, 優先度, ループ,再生速度)
                soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                // ボタンの回転アニメーション
                //RotateAnimation buttonRotation = new RotateAnimation(0, 360, button1.getWidth()/2, button1.getHeight()/2);
                //buttonRotation.setDuration(2000);
                //button1.startAnimation(buttonRotation);

                Intent intent3 = new Intent(getApplication(), RonshoActivity.class);
                startActivity(intent3);



            }
        });









    }
}
