package com.aaryanverma.yummyfy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ScrollingTabContainerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {
    Button b1;
    Spinner s1,s2,s3;
    String[] city={"Select City","Delhi","Noida"};
    String[] areadelhi={"Select Area","Shahdara","Anand Vihar"};
    String[] areanoida={"Select Area","Sec-15","Sec-16"};
    String[] shahdara={"Select Restaurant","Haldirams","Dominos"};
    String[] anandvihar={"Select Restaurant","Pizza Hut","Dunkin Donuts"};
    String[] sec15={"Select Restaurant","Rolls King","Burger King"};
    String[] sec16={"Select Restaurant","Taco Bells","Keventers"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.b1);
        s1=(Spinner)findViewById(R.id.spinner);
        s2=(Spinner)findViewById(R.id.spinner2);
        s3=(Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> obj=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,city);
        s1.setAdapter(obj);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectcity=city[position];
                if(selectcity.equals("Delhi"))
                {
                    ArrayAdapter<String> obj= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,areadelhi);
                    s2.setAdapter(obj);
                    s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String selecteddelhiarea=areadelhi[position];
                            if (selecteddelhiarea.equals("Shahdara"))
                            {
                                ArrayAdapter<String> obj= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,shahdara);
                                s3.setAdapter(obj);
                            }
                            else
                            {
                                ArrayAdapter<String> obj= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,anandvihar);
                                s3.setAdapter(obj);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });}
                else{


                        ArrayAdapter<String> obj1= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,areanoida);

                    s2.setAdapter(obj1);
                    s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String selectnoidaarea=areanoida[position];
                            if(selectnoidaarea.equals("Sec-15"))
                            {
                                ArrayAdapter<String> obj1= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,sec15);
                                s3.setAdapter(obj1);
                            }
                            else
                            {
                                ArrayAdapter<String> obj1= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,sec16);
                                s3.setAdapter(obj1);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });}
                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Main4Activity.class);
                String restaurant=s3.getSelectedItem().toString();
                    i.putExtra("allr",restaurant);
                startActivity(i);
            }
        });




    }
}
