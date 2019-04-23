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

public class SenyushutokuActivity extends AppCompatActivity {

    //占有取得　条文一覧

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
            if (position < 5 ){

                return false;
            }
            if (position > 5){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<SenyushutokuActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<SenyushutokuActivity.Person>();

            list.add(new SenyushutokuActivity.Person("第一節　占有権の取得"));//0
            list.add(new SenyushutokuActivity.Person("　第百八十一条（代理占有）"));//1
            list.add(new SenyushutokuActivity.Person("　第百八十二条（現実の引渡し及び簡易の引渡し）"));//2
            list.add(new SenyushutokuActivity.Person("　第百八十三条 （占有改定）"));//3
            list.add(new SenyushutokuActivity.Person("　第百八十四条（指図による占有移転）"));//4
            list.add(new SenyushutokuActivity.Person("　第百八十五条（占有の性質の変更）"));//5
            list.add(new SenyushutokuActivity.Person("　第百八十六条 （占有の態様等に関する推定）"));//6
            list.add(new SenyushutokuActivity.Person("　第百八十七条（占有の承継）"));//7


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
            SenyushutokuActivity.Person person = (SenyushutokuActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(17);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 5){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senyushutoku);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new SenyushutokuActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 5:

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Senyushutoku2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }





}
