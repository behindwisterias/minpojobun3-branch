package com.example.mg.minpojobun3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

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
            if (position < 13 ){

                return false;
            }
            if (position > 14 && position <20 ){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<Person>();

            list.add(new Person("総則"));//0
            list.add(new Person("第一章　通則"));//1
            list.add(new Person("第二章　人"));//2
            list.add(new Person("　第一節　権利能力"));//3
            list.add(new Person("　第二節　意思能力"));//4
            list.add(new Person("　第三節　行為能力"));//5
            list.add(new Person("　第四節　住所"));//6
            list.add(new Person("　第五節　失踪"));//7
            list.add(new Person("　第六節　同時死亡の推定"));//8
            list.add(new Person("第三章　法人")); //9番目
            list.add(new Person("第四章　物"));
            list.add(new Person("第五章　法律行為"));
            list.add(new Person("　第一節　総則"));
            list.add(new Person("　第二節　意思表示")); //13番目
            list.add(new Person("　第三節　代理"));//14番目
            list.add(new Person("　第四節　無効及び取消し"));
            list.add(new Person("　第五節　条件及び期限"));
            list.add(new Person("第六章　期間の計算"));
            list.add(new Person("第七章　時効"));
            list.add(new Person("　第一節　総則"));
            list.add(new Person("　第二節　取得時効"));//20番目
            list.add(new Person("　第三節　消滅時効"));//21番目


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
            Person person = (Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(20);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 13){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 14){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 20){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 21){
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
        setContentView(R.layout.activity_main2);

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

        lv.setAdapter(new ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 13:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                        startActivity(intent);

                        break;

                    case 14:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), DailiActivity.class);
                        startActivity(intent2);

                        break;


                    case 20:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent3 = new Intent(getApplicationContext(), ShutokujikoActivity.class);
                        startActivity(intent3);

                        break;

                    case 21:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent4 = new Intent(getApplicationContext(), ShometsujikoActivity.class);
                        startActivity(intent4);

                        break;

                }


            }
        });







    }



}

