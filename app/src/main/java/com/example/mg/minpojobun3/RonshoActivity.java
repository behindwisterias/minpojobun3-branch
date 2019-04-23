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

public class RonshoActivity extends AppCompatActivity {


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



        private Context context;
        private List<RonshoActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<RonshoActivity.Person>();

            list.add(new RonshoActivity.Person("論証一覧"));//0
            list.add(new RonshoActivity.Person("　第九十四条（虚偽表示）"));//1 177
            list.add(new RonshoActivity.Person("　第九十五条（錯誤）"));//2
            list.add(new RonshoActivity.Person("　第九十六条（詐欺又は強迫）"));//3 185
            list.add(new RonshoActivity.Person("　第百十条（権限外の行為の表見代理）"));//4 192
            list.add(new RonshoActivity.Person("　第百六十二条（所有権の取得時効）"));//5
            list.add(new RonshoActivity.Person("　第百六十三条（所有権以外の財産権の取得時効）"));//6
            list.add(new RonshoActivity.Person("　第百六十六条（債権等の消滅時効）"));//7
            list.add(new RonshoActivity.Person("　第百七十七条（不動産に関する物権の変動の対抗要件"));//8
            list.add(new RonshoActivity.Person("　第百八十五条（占有の性質の変更）")); //9番目
            list.add(new RonshoActivity.Person("　第百九十二条（即時取得）"));
            list.add(new RonshoActivity.Person("　第二百九十五条（留置権の内容）"));
            list.add(new RonshoActivity.Person("　第三百七十条（抵当権の効力の及ぶ範囲）"));
            list.add(new RonshoActivity.Person("　第四百一条 （種類債権）")); //13番目
            list.add(new RonshoActivity.Person("　第四百十二条（履行期と履行遅滞）"));//14番目 295
            list.add(new RonshoActivity.Person("　第四百十五条（債務不履行による損害賠償）")); //15
            list.add(new RonshoActivity.Person("　第四百九十三条（弁済の提供の方法）"));
            list.add(new RonshoActivity.Person("　第五百三十三条（同時履行の抗弁）"));
            list.add(new RonshoActivity.Person("　第五百四十一条（催告による解除"));
            list.add(new RonshoActivity.Person("　第五百四十五条（解除の効果）"));
            list.add(new RonshoActivity.Person("　第五百五十七条（手付）"));//20番目


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
            RonshoActivity.Person person = (RonshoActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(16);
            tvName.setHeight(120) ;
            layout.addView(tvName);


            if(position >0){
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
        setContentView(R.layout.activity_ronsho);

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

        lv.setAdapter(new RonshoActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Main7Activity.class);
                        startActivity(intent);

                        break;

                    case 2:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), Main10Activity.class);
                        startActivity(intent2);

                        break;


                    case 3:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent3 = new Intent(getApplicationContext(), Main4Activity.class);
                        startActivity(intent3);

                        break;

                    case 4:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent4 = new Intent(getApplicationContext(), Daili2Activity.class);
                        startActivity(intent4);

                        break;

                    case 5:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent5 = new Intent(getApplicationContext(), Shutokujiko2Activity.class);
                        startActivity(intent5);

                        break;


                    case 6:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent6 = new Intent(getApplicationContext(), Shutokujiko5Activity.class);
                        startActivity(intent6);

                        break;


                    case 7:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent7 = new Intent(getApplicationContext(), Shometsujiko2Activity.class);
                        startActivity(intent7);

                        break;


                    case 8:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent8 = new Intent(getApplicationContext(), Bukkensosoku2Activity.class);
                        startActivity(intent8);

                        break;

                    case 9:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent9 = new Intent(getApplicationContext(), Senyushutoku2Activity.class);
                        startActivity(intent9);

                        break;


                    case 10:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent10 = new Intent(getApplicationContext(), Senyukoryoku2Activity.class);
                        startActivity(intent10);

                        break;


                    case 11:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent11 = new Intent(getApplicationContext(), Ryuchiken2Activity.class);
                        startActivity(intent11);

                        break;


                    case 12:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent12 = new Intent(getApplicationContext(), Teitoken2Activity.class);
                        startActivity(intent12);

                        break;


                    case 13:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent13 = new Intent(getApplicationContext(), Saikenmokuteki2Activity.class);
                        startActivity(intent13);

                        break;


                    case 14:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent14 = new Intent(getApplicationContext(), Saimufuriko2Activity.class);
                        startActivity(intent14);

                        break;


                    case 15:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent15 = new Intent(getApplicationContext(), Saimufuriko5Activity.class);
                        startActivity(intent15);

                        break;




                    case 16:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent16 = new Intent(getApplicationContext(), Bensai2Activity.class);
                        startActivity(intent16);

                        break;


                    case 17:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent17 = new Intent(getApplicationContext(), Keiyakukoryoku2Activity.class);
                        startActivity(intent17);

                        break;


                    case 18:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent18 = new Intent(getApplicationContext(), Keiyakukaijo2Activity.class);
                        startActivity(intent18);

                        break;


                    case 19:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent19 = new Intent(getApplicationContext(), Keiyakukaijo5Activity.class);
                        startActivity(intent19);

                        break;


                    case 20:

                        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                        // 第2引数は適宜
                        Intent intent20 = new Intent(getApplicationContext(), Baibaisosoku2Activity.class);
                        startActivity(intent20);

                        break;






                }


            }
        });







    }







}
