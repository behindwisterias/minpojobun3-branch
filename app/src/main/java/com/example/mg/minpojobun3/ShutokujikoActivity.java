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

public class ShutokujikoActivity extends AppCompatActivity {

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
        private List<ShutokujikoActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<ShutokujikoActivity.Person>();

            list.add(new ShutokujikoActivity.Person("第二節　取得時効"));//0
            list.add(new ShutokujikoActivity.Person("　第百六十二条（所有権の取得時効）"));//1
            list.add(new ShutokujikoActivity.Person("　第百六十三条（所有権以外の財産権の取得時効）"));//2
            list.add(new ShutokujikoActivity.Person("　第百六十四条（占有の中止等による取得時効の中断）"));//3
            list.add(new ShutokujikoActivity.Person("　第百六十五条"));//4


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
            ShutokujikoActivity.Person person = (ShutokujikoActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(15);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 1){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
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
        setContentView(R.layout.activity_shutokujiko);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new ShutokujikoActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Shutokujiko2Activity.class);
                        startActivity(intent);


                        break;


                    case 2:

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), Shutokujiko5Activity.class);
                        startActivity(intent2);


                        break;


                }


            }
        });







    }

}
