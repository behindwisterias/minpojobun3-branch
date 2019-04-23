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

public class DailiActivity extends AppCompatActivity {

    //代理　条文一覧

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
            if (position < 11 ){

                return false;
            }
            if (position > 11){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<DailiActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<DailiActivity.Person>();

            list.add(new DailiActivity.Person("第三節　代理"));//0
            list.add(new DailiActivity.Person("　第百条（本人のためにすることを示さない意思表示）"));//1
            list.add(new DailiActivity.Person("　第百一条（代理行為の瑕疵）"));//2
            list.add(new DailiActivity.Person("　第百二条（代理人の行為能力）"));//3
            list.add(new DailiActivity.Person("　第百三条 （権限の定めのない代理人の権限）"));//4
            list.add(new DailiActivity.Person("　第百四条（任意代理人による復代理人の選任）"));//5
            list.add(new DailiActivity.Person("　第百五条（法定代理人による復代理人の選任）"));//6
            list.add(new DailiActivity.Person("　第百六条 （復代理人の権限等）\n"));//
            list.add(new DailiActivity.Person("　第百七条（代理権の濫用）"));//
            list.add(new DailiActivity.Person("　第百八条（自己契約及び双方代理等）"));//
            list.add(new DailiActivity.Person("　第百九条（代理権授与の表示による表見代理等）"));
            list.add(new DailiActivity.Person("　第百十条（権限外の行為の表見代理）"));//11
            list.add(new DailiActivity.Person("　第百十一条（代理権の消滅事由）"));
            list.add(new DailiActivity.Person("　第百十二条（代理権消滅後の表見代理等）"));
            list.add(new DailiActivity.Person("　第百十三条（無権代理）"));
            list.add(new DailiActivity.Person("　第百十四条 （無権代理の相手方の催告権）"));
            list.add(new DailiActivity.Person("　第百十五条（無権代理の相手方の取消権）"));
            list.add(new DailiActivity.Person("　第百十六条 （無権代理行為の追認）"));
            list.add(new DailiActivity.Person("　第百十七条（無権代理人の責任）"));
            list.add(new DailiActivity.Person("　第百十八条（単独行為の無権代理）"));



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
            DailiActivity.Person person = (DailiActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(15);
            tvName.setHeight(70) ;
            layout.addView(tvName);


            if(position == 11){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daili);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new DailiActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 11:

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Daili2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }

}
