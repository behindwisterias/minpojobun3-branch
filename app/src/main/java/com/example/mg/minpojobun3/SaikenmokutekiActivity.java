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

public class SaikenmokutekiActivity extends AppCompatActivity {


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
            if (position < 3 ){

                return false;
            }
            if (position > 3){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<SaikenmokutekiActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<SaikenmokutekiActivity.Person>();

            list.add(new SaikenmokutekiActivity.Person("第一節　債権の目的"));//0
            list.add(new SaikenmokutekiActivity.Person("　第三百九十九条（債権の目的）"));//1
            list.add(new SaikenmokutekiActivity.Person("　第四百条（特定物の引渡しの場合の注意義務）"));//2
            list.add(new SaikenmokutekiActivity.Person("　第四百一条 （種類債権）"));//3
            list.add(new SaikenmokutekiActivity.Person("　第四百二条（金銭債権）"));//4
            list.add(new SaikenmokutekiActivity.Person("　第四百三条"));//5
            list.add(new SaikenmokutekiActivity.Person("　第四百四条（法定利率）"));//0
            list.add(new SaikenmokutekiActivity.Person("　第四百五条（利息の元本への組入れ）"));//1
            list.add(new SaikenmokutekiActivity.Person("　第四百六条（選択債権における選択権の帰属）"));//2
            list.add(new SaikenmokutekiActivity.Person("　第四百七条（選択権の行使）"));//3
            list.add(new SaikenmokutekiActivity.Person("　第四百八条（選択権の移転）"));//4
            list.add(new SaikenmokutekiActivity.Person("　第四百九条（第三者の選択権）"));//5
            list.add(new SaikenmokutekiActivity.Person("　第四百十条（不能による選択債権の特定）"));//0
            list.add(new SaikenmokutekiActivity.Person("　第四百十一条（選択の効力）"));//1

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
            SaikenmokutekiActivity.Person person = (SaikenmokutekiActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(15);
            tvName.setHeight(70) ;
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
        setContentView(R.layout.activity_saikenmokuteki);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new SaikenmokutekiActivity.ListPersonAdapter(this));


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
                        Intent intent = new Intent(getApplicationContext(), Saikenmokuteki2Activity.class);
                        startActivity(intent);


                        break;



                }


            }
        });







    }
    
    
    
    
}
