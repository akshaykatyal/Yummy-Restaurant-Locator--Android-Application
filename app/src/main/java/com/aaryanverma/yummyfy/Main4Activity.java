package com.aaryanverma.yummyfy;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

public class Main4Activity extends AppCompatActivity {
    Button b1,b2;
    ImageView img1;
    RatingBar rating;
    TextView t1;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        list=(ListView)findViewById(R.id.list1);
        String[] reviews={"Good","Excellent","Nice Food"};
        img1=(ImageView)findViewById(R.id.img);
        rating=(RatingBar)findViewById(R.id.r1);
        ArrayAdapter<String> ar=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,reviews);
        list.setAdapter(ar);
        String[] rest={"Haldirams","Dominos","Taco Bells","Rolls king","Burger King","Pizza Hut","Keventers","Dunkin Donuts"};
        int[] img={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        double[] ratingBar={4,4,4,3,5,4,4,4};
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(i);
            }
        });
        String restname=getIntent().getStringExtra("allr");
        for (int i=0;i<rest.length;i++)
        {
            if (restname.equals(rest[i]))
            {
                img1.setImageResource(img[i]);
                rating.setRating((float)ratingBar[i]);
            }

        }




    }
}
