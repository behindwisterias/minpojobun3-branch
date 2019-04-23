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

public class SaimufurikoActivity extends AppCompatActivity {


    //債権の目的　条文一覧

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
            if (position > 1 && position < 6){

                return false;
            }
            if (position > 1 && position < 6){

                return false;
            }
            if (position > 6){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<SaimufurikoActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<SaimufurikoActivity.Person>();

            list.add(new SaimufurikoActivity.Person("第一款　債務不履行の責任等"));//0
            list.add(new SaimufurikoActivity.Person("　第四百十二条（履行期と履行遅滞）"));//1
            list.add(new SaimufurikoActivity.Person("　第四百十二条の二（履行不能）"));//2
            list.add(new SaimufurikoActivity.Person("　第四百十三条（受領遅滞）"));//3
            list.add(new SaimufurikoActivity.Person("　第四百十三条の二（履行遅滞中又は受領遅滞中の履行不能と帰責事由）"));//4
            list.add(new SaimufurikoActivity.Person("　第四百十四条（履行の強制）"));//5
            list.add(new SaimufurikoActivity.Person("　第四百十五条（債務不履行による損害賠償）"));//6
            list.add(new SaimufurikoActivity.Person("　第四百十六条（損害賠償の範囲）"));//1
            list.add(new SaimufurikoActivity.Person("　第四百十七条（損害賠償の方法）"));//2
            list.add(new SaimufurikoActivity.Person("　第四百十七条の二（中間利息の控除）"));//3
            list.add(new SaimufurikoActivity.Person("　第四百十八条（過失相殺）"));//4
            list.add(new SaimufurikoActivity.Person("　第四百十九条（金銭債務の特則）"));//5
            list.add(new SaimufurikoActivity.Person("　第四百二十条（賠償額の予定）"));//0
            list.add(new SaimufurikoActivity.Person("　第四百二十一条"));//1
            list.add(new SaimufurikoActivity.Person("　第四百二十二条（損害賠償による代位）"));//5
            list.add(new SaimufurikoActivity.Person("　第四百二十二条の二（代償請求権）"));//0

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
            SaimufurikoActivity.Person person = (SaimufurikoActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(15);
            tvName.setHeight(150) ;
            tvName.setPadding(60,30,60,30);
            layout.addView(tvName);


            if(position == 1){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }
            if(position == 6){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saimufuriko);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new SaimufurikoActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Saimufuriko2Activity.class);
                        startActivity(intent);


                        break;

                    case 6:

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), Saimufuriko5Activity.class);
                        startActivity(intent2);


                        break;



                }


            }
        });







    }



}
