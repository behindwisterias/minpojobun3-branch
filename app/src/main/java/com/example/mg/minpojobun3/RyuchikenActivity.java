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

public class RyuchikenActivity extends AppCompatActivity {


    //留置権　条文一覧

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
            if (position > 1){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<RyuchikenActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<RyuchikenActivity.Person>();

            list.add(new RyuchikenActivity.Person("第七章　留置権"));//0
            list.add(new RyuchikenActivity.Person("　第二百九十五条（留置権の内容）"));//1
            list.add(new RyuchikenActivity.Person("　第二百九十六条（留置権の不可分性）"));//2
            list.add(new RyuchikenActivity.Person("　第二百九十七条（留置権者による果実の収取）"));//3
            list.add(new RyuchikenActivity.Person("　第二百九十八条（留置権者による留置物の保管等）"));//4
            list.add(new RyuchikenActivity.Person("　第二百九十九条（留置権者による費用の償還請求）"));//5
            list.add(new RyuchikenActivity.Person("　第三百条（留置権の行使と債権の消滅時効）"));//1
            list.add(new RyuchikenActivity.Person("　第三百一条（担保の供与による留置権の消滅）"));//2
            list.add(new RyuchikenActivity.Person("　第三百二条（占有の喪失による留置権の消滅）"));//3


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
            RyuchikenActivity.Person person = (RyuchikenActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(16);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 1){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ryuchiken);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new RyuchikenActivity.ListPersonAdapter(this));


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

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Ryuchiken2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }



}
