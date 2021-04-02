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

public class Main3Activity extends AppCompatActivity {
    Button b1;
    Spinner s1,s2,s3;
    String[] city={"Select City","Delhi","Noida"};
    String[] areadelhi={"Select Area","Connaught Place","GTB Nagar"};
    String[] areanoida={"Select Area","Sec-18","Sec-36"};
    String[] cp={"Select Cafe","JunkYard Cafe","MyBar"};
    String[] gtb={"Select Cafe","Flamess","BYD"};
    String[] sec18={"Select Cafe","Taxi Cafe","The Paddys Cafe"};
    String[] sec36={"Select Cafe","Cafe Underground","London Cafe"};


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
                            if (selecteddelhiarea.equals("Connaught Place"))
                            {
                                ArrayAdapter<String> obj= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,cp);
                                s3.setAdapter(obj);
                            }
                            else
                            {
                                ArrayAdapter<String> obj= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,gtb);
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
                            if(selectnoidaarea.equals("Sec-18"))
                            {
                                ArrayAdapter<String> obj1= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,sec18);
                                s3.setAdapter(obj1);
                            }
                            else
                            {
                                ArrayAdapter<String> obj1= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,sec36);
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
                String cafe=s1.getSelectedItem().toString();
                i.putExtra("allc",cafe);
                startActivity(i);
            }
        });




    }
}
