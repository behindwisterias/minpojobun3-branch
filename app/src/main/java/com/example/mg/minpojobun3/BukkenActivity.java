package com.example.mg.minpojobun3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BukkenActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundOne, soundTwo;



    private class Person {
        private String name;
        //private int age;

        public Person(String name) {
            this.name = name;
            //this.age = age;
        }

        public String getName() {
            return name;
        }

        //public int getAge() {
        //    return age;
        //}
    }


    private class ListPersonAdapter extends BaseAdapter {

        @Override
        public boolean isEnabled(int position) {

            if (position == 0 ){

                return false;
            }
            if (position == 2 ){

                return false;
            }
            if (position > 4 && position < 14 ){

                return false;
            }
            if (position > 14 && position < 26 ){

                return false;
            }
            if (position > 26 && position < 29 ){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<BukkenActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<BukkenActivity.Person>();

            list.add(new BukkenActivity.Person("物権"));//0
            list.add(new BukkenActivity.Person("第一章　総則"));//1 177
            list.add(new BukkenActivity.Person("第二章　占有権"));//2
            list.add(new BukkenActivity.Person("　第一節　占有権の取得"));//3 185
            list.add(new BukkenActivity.Person("　第二節　占有権の効力"));//4 192
            list.add(new BukkenActivity.Person("　第三節　占有権の消滅"));//5
            list.add(new BukkenActivity.Person("　第四節　準占有"));//6
            list.add(new BukkenActivity.Person("第三章　所有権"));//7
            list.add(new BukkenActivity.Person("　第一節　所有権の限界"));//8
            list.add(new BukkenActivity.Person("　第二節　所有権の取得")); //9番目
            list.add(new BukkenActivity.Person("　第三節　共有"));
            list.add(new BukkenActivity.Person("第四章　地上権"));
            list.add(new BukkenActivity.Person("第五章　永小作権"));
            list.add(new BukkenActivity.Person("第六章　地役権")); //13番目
            list.add(new BukkenActivity.Person("第七章　留置権"));//14番目 295
            list.add(new BukkenActivity.Person("第八章　先取特権")); //15
            list.add(new BukkenActivity.Person("　第一節　総則"));
            list.add(new BukkenActivity.Person("　第二節　先取特権の種類"));
            list.add(new BukkenActivity.Person("　第三節　先取特権の順位"));
            list.add(new BukkenActivity.Person("　第四節　先取特権の効力"));
            list.add(new BukkenActivity.Person("第九章　質権"));//20番目
            list.add(new BukkenActivity.Person("　第一節　総則"));//21番目
            list.add(new BukkenActivity.Person("　第二節　動産質"));//22番目
            list.add(new BukkenActivity.Person("　第三節　不動産質"));//23番目
            list.add(new BukkenActivity.Person("　第四節　権利質"));//24番目
            list.add(new BukkenActivity.Person("第十章　抵当権"));//25番目
            list.add(new BukkenActivity.Person("　第一節　総則"));//26番目 370
            list.add(new BukkenActivity.Person("　第二節　抵当権の効力"));//27番目
            list.add(new BukkenActivity.Person("　第三節　抵当権の消滅"));//28番目
            list.add(new BukkenActivity.Person("　第四節　根抵当"));//29番目


        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {

            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            BukkenActivity.Person person = (BukkenActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(20);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 1){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 3){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 4){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 14){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 26){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }


            //TextView tvAge = new TextView(context);
            //tvAge.setText(String.format("%d 才", person.getAge()));
            //layout.addView(tvAge);


            return convertView;
        }





    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukken);

        //soundpool関係
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



        //adapter関係、画面遷移関係

        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new BukkenActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 1:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), BukkensosokuActivity.class);
                        startActivity(intent);

                        break;

                    case 3:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), SenyushutokuActivity.class);
                        startActivity(intent2);

                        break;


                    case 4:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent3 = new Intent(getApplicationContext(), SenyukoryokuActivity.class);
                        startActivity(intent3);

                        break;

                    case 14:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent4 = new Intent(getApplicationContext(), RyuchikenActivity.class);
                        startActivity(intent4);

                        break;

                    case 26:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent5 = new Intent(getApplicationContext(), TeitokenActivity.class);
                        startActivity(intent5);

                        break;

                }


            }
        });







    }

}
