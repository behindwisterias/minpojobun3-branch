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

public class TeitokenActivity extends AppCompatActivity {

    //取得時効　条文一覧

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
            if (position < 1 ){

                return false;
            }
            if (position > 2){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<TeitokenActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<TeitokenActivity.Person>();

            list.add(new TeitokenActivity.Person("第一節　総則"));//0
            list.add(new TeitokenActivity.Person("　第三百六十九条（抵当権の内容）"));//1
            list.add(new TeitokenActivity.Person("　第三百七十条（抵当権の効力の及ぶ範囲）"));//2
            list.add(new TeitokenActivity.Person("　第三百七十一条"));//3
            list.add(new TeitokenActivity.Person("　第三百七十二条（留置権等の規定の準用）"));//4


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
            TeitokenActivity.Person person = (TeitokenActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(17);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 2){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }




            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teitoken);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new TeitokenActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Teitoken2Activity.class);
                        startActivity(intent);


                        break;




                }


            }
        });







    }
    
    
    
    
    
}
