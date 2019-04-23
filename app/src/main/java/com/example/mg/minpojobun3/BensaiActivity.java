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

public class BensaiActivity extends AppCompatActivity {


    //弁済総則　条文一覧

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
            if (position < 20 ){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<BensaiActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<BensaiActivity.Person>();

            list.add(new BensaiActivity.Person("第一目　総則"));//0
            list.add(new BensaiActivity.Person("　第四百七十四条（第三者の弁済）"));//1
            list.add(new BensaiActivity.Person("　第四百七十五条（弁済として引き渡した物の取戻し）"));//2
            list.add(new BensaiActivity.Person("　第四百七十六条（弁済として引き渡した物の消費又は譲渡がされた場合の弁済の効力等）"));//3
            list.add(new BensaiActivity.Person("　第四百七十七条（預金又は貯金の口座に対する払込みによる弁済）"));//4
            list.add(new BensaiActivity.Person("　第四百七十八条（受領権者としての外観を有する者に対する弁済）"));//5
            list.add(new BensaiActivity.Person("　第四百七十九条（受領権者以外の者に対する弁済）"));//6
            list.add(new BensaiActivity.Person("　第四百八十条 　削除"));//7
            list.add(new BensaiActivity.Person("　第四百八十一条（差押えを受けた第三債務者の弁済）"));//8
            list.add(new BensaiActivity.Person("　第四百八十二条（代物弁済）"));//9
            list.add(new BensaiActivity.Person("　第四百八十三条（特定物の現状による引渡し）"));//10
            list.add(new BensaiActivity.Person("　第四百八十四条（弁済の場所及び時間）"));//
            list.add(new BensaiActivity.Person("　第四百八十五条（弁済の費用）"));//
            list.add(new BensaiActivity.Person("　第四百八十六条（受取証書の交付請求）"));//
            list.add(new BensaiActivity.Person("　第四百八十七条（債権証書の返還請求）"));//
            list.add(new BensaiActivity.Person("　第四百八十八条（同種の給付を目的とする数個の債務がある場合の充当）"));//
            list.add(new BensaiActivity.Person("　第四百八十九条（元本、利息及び費用を支払うべき場合の充当）"));//
            list.add(new BensaiActivity.Person("　第四百九十条（合意による弁済の充当）"));//
            list.add(new BensaiActivity.Person("　第四百九十一条（数個の給付をすべき場合の充当）"));//
            list.add(new BensaiActivity.Person("　第四百九十二条（弁済の提供の効果）"));//
            list.add(new BensaiActivity.Person("　第四百九十三条（弁済の提供の方法）"));//20

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
            BensaiActivity.Person person = (BensaiActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(14);
            tvName.setHeight(110) ;
            tvName.setPadding(30,0,30,0);
            layout.addView(tvName);


            if(position == 20){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bensai);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new BensaiActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 20:

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Bensai2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }





}
