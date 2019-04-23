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

public class KeiyakukaijoActivity extends AppCompatActivity {

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
            if (position < 2 ){

                return false;
            }
            if (position >2 && position < 6 ){

                return false;
            }
            if (position >6 ){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<KeiyakukaijoActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<KeiyakukaijoActivity.Person>();

            list.add(new KeiyakukaijoActivity.Person("第四款　契約の解除"));//0
            list.add(new KeiyakukaijoActivity.Person("　第五百四十条（解除権の行使）"));//1
            list.add(new KeiyakukaijoActivity.Person("　第五百四十一条（催告による解除）"));//2
            list.add(new KeiyakukaijoActivity.Person("　第五百四十二条（催告によらない解除）"));//3
            list.add(new KeiyakukaijoActivity.Person("　第五百四十三条（債権者の責めに帰すべき事由による場合）"));//4
            list.add(new KeiyakukaijoActivity.Person("　第五百四十四条（解除権の不可分性）"));//5
            list.add(new KeiyakukaijoActivity.Person("　第五百四十五条（解除の効果）"));//6
            list.add(new KeiyakukaijoActivity.Person("　第五百四十六条（契約の解除と同時履行）"));//7
            list.add(new KeiyakukaijoActivity.Person("　第五百四十七条（催告による解除権の消滅）"));//8
            list.add(new KeiyakukaijoActivity.Person("　第五百四十八条（解除権者の故意による目的物の損壊等による解除権の消滅）"));//9



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
            KeiyakukaijoActivity.Person person = (KeiyakukaijoActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(14);
            tvName.setHeight(90) ;
            tvName.setPadding(30,0,30,0);
            layout.addView(tvName);


            if(position == 2){
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
        setContentView(R.layout.activity_keiyakukaijo);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new KeiyakukaijoActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Keiyakukaijo2Activity.class);
                        startActivity(intent);


                        break;

                    case 6:

                        // 第2引数は適宜
                        Intent intent2 = new Intent(getApplicationContext(), Keiyakukaijo5Activity.class);
                        startActivity(intent2);


                        break;



                }


            }
        });







    }
    
    
    
    
    
}
