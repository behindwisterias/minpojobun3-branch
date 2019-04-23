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

public class BaibaisosokuActivity extends AppCompatActivity {


    //契約解除　条文一覧

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

            if (position >3 ){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<BaibaisosokuActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<BaibaisosokuActivity.Person>();

            list.add(new BaibaisosokuActivity.Person("第一款　総則"));//0
            list.add(new BaibaisosokuActivity.Person("　第五百五十五条（売買）"));//1
            list.add(new BaibaisosokuActivity.Person("　第五百五十六条（売買の一方の予約）"));//2
            list.add(new BaibaisosokuActivity.Person("　第五百五十七条（手付）"));//3
            list.add(new BaibaisosokuActivity.Person("　第五百五十八条（売買契約に関する費用）"));//4
            list.add(new BaibaisosokuActivity.Person("　第五百五十九条（有償契約への準用）"));//5


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
            BaibaisosokuActivity.Person person = (BaibaisosokuActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(17);
            tvName.setHeight(90) ;
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
        setContentView(R.layout.activity_baibaisosoku);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new BaibaisosokuActivity.ListPersonAdapter(this));


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
                        Intent intent2 = new Intent(getApplicationContext(), Baibaisosoku2Activity.class);
                        startActivity(intent2);


                        break;



                }


            }
        });







    }









}
