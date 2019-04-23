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

public class SaikenActivity extends AppCompatActivity {


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
            if (position == 1 ){

                return false;
            }
            if (position == 3 ){

                return false;
            }
            if (position > 4 && position < 19 ){

                return false;
            }
            if (position > 19 && position < 34 ){

                return false;
            }
            if (position > 34 && position < 36 ){

                return false;
            }
            if (position > 36 && position < 40 ){

                return false;
            }
            if (position > 40){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<SaikenActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<SaikenActivity.Person>();

            list.add(new SaikenActivity.Person("債権"));//0
            list.add(new SaikenActivity.Person("第一章　総則"));//1 401
            list.add(new SaikenActivity.Person("　第一節　債権の目的"));//2
            list.add(new SaikenActivity.Person("　第二節　債権の効力"));//3
            list.add(new SaikenActivity.Person("　　第一款　債務不履行の責任等"));//4 412
            list.add(new SaikenActivity.Person("　　第二款　債権者代位権"));//5
            list.add(new SaikenActivity.Person("　　第三款　詐害行為取消権"));//6
            list.add(new SaikenActivity.Person("　第三節　多数当事者の債権及び債務"));//7
            list.add(new SaikenActivity.Person("　　第一款　総則"));//8
            list.add(new SaikenActivity.Person("　　第二款　不可分債権及び不可分債務")); //9番目
            list.add(new SaikenActivity.Person("　　第三款　連帯債権"));
            list.add(new SaikenActivity.Person("　　第四款　連帯債務"));
            list.add(new SaikenActivity.Person("　　第五款　保証債務"));
            list.add(new SaikenActivity.Person("　第四節　債権の譲渡")); //13番目
            list.add(new SaikenActivity.Person("　第五節　債務の引受け"));//14番目 295
            list.add(new SaikenActivity.Person("　　第一款　併存的債務引受")); //15
            list.add(new SaikenActivity.Person("　　第二款　免責的債務引受"));
            list.add(new SaikenActivity.Person("　第六節　債権の消滅"));
            list.add(new SaikenActivity.Person("　　第一款　弁済"));
            list.add(new SaikenActivity.Person("　　　第一目　総則")); //19  493
            list.add(new SaikenActivity.Person("　　　第二目　弁済の目的物の供託"));//20番目
            list.add(new SaikenActivity.Person("　　　第三目　弁済による代位"));//21番目
            list.add(new SaikenActivity.Person("　　第二款　相殺"));//22番目
            list.add(new SaikenActivity.Person("　　第三款　更改"));//23番目
            list.add(new SaikenActivity.Person("　　第四款　免除"));//24番目
            list.add(new SaikenActivity.Person("　　第五款　混同"));//25番目
            list.add(new SaikenActivity.Person("　第七節  有価証券"));//26番目 370
            list.add(new SaikenActivity.Person("　　第一款  指図証券"));//27番目
            list.add(new SaikenActivity.Person("　　第二款   記名式所持人払証券"));//28番目
            list.add(new SaikenActivity.Person("　　第三款   その他の記名証券"));//29番目
            list.add(new SaikenActivity.Person("　　第四款    無記名証券"));//30
            list.add(new SaikenActivity.Person("第二章　契約"));//31
            list.add(new SaikenActivity.Person("　第一節　総則")); //32番目
            list.add(new SaikenActivity.Person("　　第一款　契約の成立"));//33番目 295
            list.add(new SaikenActivity.Person("　　第二款　契約の効力")); //34  533
            list.add(new SaikenActivity.Person("　　第三款  契約上の地位の移転"));//35
            list.add(new SaikenActivity.Person("　　第四款　契約の解除"));//36番目　541 545
            list.add(new SaikenActivity.Person("　　第五款   定型約款"));//37
            list.add(new SaikenActivity.Person("　第二節　贈与"));//38
            list.add(new SaikenActivity.Person("　第三節　売買"));//39番目
            list.add(new SaikenActivity.Person("　　第一款　総則"));//40番目　557
            list.add(new SaikenActivity.Person("　　第二款　売買の効力"));//41番目
            list.add(new SaikenActivity.Person("　　第三款　買戻し"));//42番目
            list.add(new SaikenActivity.Person("　第四節　交換"));//43番目
            list.add(new SaikenActivity.Person("　第五節　消費貸借"));//44番目
            list.add(new SaikenActivity.Person("　第六節　使用貸借"));//45番目 370
            list.add(new SaikenActivity.Person("　第七節　賃貸借"));//46番目
            list.add(new SaikenActivity.Person("　　第一款　総則"));//47番目
            list.add(new SaikenActivity.Person("　　第二款　賃貸借の効力"));//48番目
            list.add(new SaikenActivity.Person("　　第三款　賃貸借の終了"));//49
            list.add(new SaikenActivity.Person("　　第四款　敷金"));//50
            list.add(new SaikenActivity.Person("　第八節　雇用"));//51
            list.add(new SaikenActivity.Person("　第九節　請負"));//52
            list.add(new SaikenActivity.Person("　第十節　委任"));//53
            list.add(new SaikenActivity.Person("　第十一節　寄託"));//54
            list.add(new SaikenActivity.Person("　第十二節　組合"));//55
            list.add(new SaikenActivity.Person("　第十三節　終身定期金"));//56
            list.add(new SaikenActivity.Person("　第十四節　和解"));//57



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
            SaikenActivity.Person person = (SaikenActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(20);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 2){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 4){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 19){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 34){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 36){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 40){
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
        setContentView(R.layout.activity_saiken);

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

        lv.setAdapter(new SaikenActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 2:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), SaikenmokutekiActivity.class);
                        startActivity(intent);

                        break;

                    case 4:
                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), SaimufurikoActivity.class);
                        startActivity(intent2);

                        break;


                    case 19:
                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent3 = new Intent(getApplicationContext(), BensaiActivity.class);
                        startActivity(intent3);

                        break;

                    case 34:
                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent4 = new Intent(getApplicationContext(), KeiyakukoryokuActivity.class);
                        startActivity(intent4);

                        break;

                    case 36:
                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent5 = new Intent(getApplicationContext(), KeiyakukaijoActivity.class);
                        startActivity(intent5);

                        break;


                    case 40:
                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent6 = new Intent(getApplicationContext(), BaibaisosokuActivity.class);
                        startActivity(intent6);

                        break;


                }


            }
        });







    }












}
