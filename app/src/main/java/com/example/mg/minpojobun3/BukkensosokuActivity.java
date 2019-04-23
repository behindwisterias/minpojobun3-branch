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
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BukkensosokuActivity extends AppCompatActivity {

    //物権総則　条文一覧

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
            if (position < 3 ){

                return false;
            }
            if (position > 3){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<BukkensosokuActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<BukkensosokuActivity.Person>();

            list.add(new BukkensosokuActivity.Person("第一章　総則"));//0
            list.add(new BukkensosokuActivity.Person("　第百七十五条（物権の創設）"));//1
            list.add(new BukkensosokuActivity.Person("　第百七十六条（物権の設定及び移転）"));//2
            list.add(new BukkensosokuActivity.Person("　第百七十七条（不動産に関する物権の変動の対抗要件）"));//3
            list.add(new BukkensosokuActivity.Person("　第百七十八条（動産に関する物権の譲渡の対抗要件）"));//4
            list.add(new BukkensosokuActivity.Person("　第百七十九条（混同）"));//5


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
            BukkensosokuActivity.Person person = (BukkensosokuActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(15);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 3){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukkensosoku);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new BukkensosokuActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 3:

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Bukkensosoku2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }



}
