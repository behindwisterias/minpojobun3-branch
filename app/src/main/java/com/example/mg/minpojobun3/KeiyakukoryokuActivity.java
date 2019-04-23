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

public class KeiyakukoryokuActivity extends AppCompatActivity {


    //契約効力　条文一覧

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
            if (position >1 && position < 1 ){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<KeiyakukoryokuActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<KeiyakukoryokuActivity.Person>();

            list.add(new KeiyakukoryokuActivity.Person("第二款　契約の効力"));//0
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十三条（同時履行の抗弁）"));//1
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十四条 　削除"));//2
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十五条 　削除"));//3
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十六条（債務者の危険負担等）"));//4
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十七条（第三者のためにする契約）"));//5
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十八条（第三者の権利の確定）"));//6
            list.add(new KeiyakukoryokuActivity.Person("　第五百三十九条（債務者の抗弁）"));//7


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
            KeiyakukoryokuActivity.Person person = (KeiyakukoryokuActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(17);
            tvName.setHeight(100) ;
            tvName.setPadding(30,0,30,0);
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
        setContentView(R.layout.activity_keiyakukoryoku);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new KeiyakukoryokuActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Keiyakukoryoku2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }
    
    
    
    
    
    
    
    
    
    
    
    
}
