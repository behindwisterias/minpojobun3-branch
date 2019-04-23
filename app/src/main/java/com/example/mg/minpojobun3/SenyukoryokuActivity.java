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

public class SenyukoryokuActivity extends AppCompatActivity {

    //占有効力
    
    
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
            if (position < 5 ){

                return false;
            }
            if (position > 5){

                return false;
            }

            else{
                return true;
            }
        }

        private Context context;
        private List<SenyukoryokuActivity.Person> list;

        public ListPersonAdapter(Context context) {
            super();
            this.context = context;
            list = new ArrayList<SenyukoryokuActivity.Person>();

            list.add(new SenyukoryokuActivity.Person("第二節　占有権の効力"));//0
            list.add(new SenyukoryokuActivity.Person("　第百八十八条（占有物について行使する権利の適法の推定）"));//1
            list.add(new SenyukoryokuActivity.Person("　第百八十九条（善意の占有者による果実の取得等）"));//2
            list.add(new SenyukoryokuActivity.Person("　第百九十条 （悪意の占有者による果実の返還等）"));//3
            list.add(new SenyukoryokuActivity.Person("　第百九十一条（占有者による損害賠償）"));//4
            list.add(new SenyukoryokuActivity.Person("　第百九十二条（即時取得）"));//5
            list.add(new SenyukoryokuActivity.Person("　第百九十三条（盗品又は遺失物の回復）"));//6
            list.add(new SenyukoryokuActivity.Person("　第百九十四条"));//7
            list.add(new SenyukoryokuActivity.Person("　第百九十五条（動物の占有による権利の取得）"));//4
            list.add(new SenyukoryokuActivity.Person("　第百九十六条 （占有者による費用の償還請求）"));//5
            list.add(new SenyukoryokuActivity.Person("　第百九十七条（占有の訴え）"));//6
            list.add(new SenyukoryokuActivity.Person("　第百九十八条（占有保持の訴え）"));//7
            list.add(new SenyukoryokuActivity.Person("　第百九十九条（占有保全の訴え）"));//4
            list.add(new SenyukoryokuActivity.Person("　第二百条（占有回収の訴え）"));//5
            list.add(new SenyukoryokuActivity.Person("　第二百一条（占有の訴えの提起期間）"));//6
            list.add(new SenyukoryokuActivity.Person("　第二百二条 （本権の訴えとの関係）"));//7


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
            SenyukoryokuActivity.Person person = (SenyukoryokuActivity.Person) getItem(position);

            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            convertView = layout;

            TextView tvName = new TextView(context);
            tvName.setText(person.getName());
            tvName.setTextSize(15);
            tvName.setHeight(150) ;
            tvName.setPadding(50,30,50,30);
            layout.addView(tvName);


            if(position == 5){
                // テキストの色を変更
                tvName.setTextColor(Color.rgb(0, 0, 255));
            }



            return convertView;
        }





    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senyukoryoku);


        ListView lv = new ListView(this);
        setContentView(lv);
        lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
        lv.setDividerHeight(50);

        lv.setAdapter(new SenyukoryokuActivity.ListPersonAdapter(this));


        //画面遷移 Main3Activityへ

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView
                //ListView listView = (ListView)parent;
                // 選択された項目
                //String selectedItemStr = (String)listView.getItemAtPosition(position);

                switch(position) {
                    case 5:

                        // 第2引数は適宜
                        Intent intent = new Intent(getApplicationContext(), Senyukoryoku2Activity.class);
                        startActivity(intent);


                        break;


                }


            }
        });


    }
    
    
    
    
    
}
