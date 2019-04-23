package com.example.mg.minpojobun3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {


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
            if (position < 2 ){

                return false;
            }
            if (position > 4){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<Main3Activity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<Main3Activity.Person>();

            list.add(new Main3Activity.Person("第二節　意思表示"));//0
            list.add(new Main3Activity.Person("　第九十三条（心裡留保）"));//1
            list.add(new Main3Activity.Person("　第九十四条（虚偽表示）"));//2
            list.add(new Main3Activity.Person("　第九十五条（錯誤）"));//3
            list.add(new Main3Activity.Person("　第九十六条（詐欺又は強迫）"));//4
            list.add(new Main3Activity.Person("　第九十七条（意思表示の効力発生時期等）"));//5
            list.add(new Main3Activity.Person("　第九十八条（公示による意思表示）"));//6


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
            Main3Activity.Person person = (Main3Activity.Person) getItem(position);

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
            if(position == 3){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 4){
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


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new Main3Activity.ListPersonAdapter(this));


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

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), Main7Activity.class);
                        startActivity(intent2);


                        break;


                    case 3:

                        // 第2引数は適宜
                        Intent intent3 = new Intent(getApplicationContext(), Main10Activity.class);
                        startActivity(intent3);


                        break;

                    case 4:

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
                        startActivity(intent);


                        break;
                }


            }
        });







    }









}
