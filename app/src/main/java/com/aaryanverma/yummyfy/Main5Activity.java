package com.aaryanverma.yummyfy;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6;
    Button b1;
    String s1,s2,s3,s4,s5,s6;
    int random, tablenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b1=(Button)findViewById(R.id.b1);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        et4=(EditText) findViewById(R.id.et4);
        et5=(EditText) findViewById(R.id.et5);
        et6=(EditText) findViewById(R.id.et6);
        db obj=new db(getApplicationContext(),"reg",null,3);
        final SQLiteDatabase db=obj.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=et1.getText().toString();
                s2=et2.getText().toString();
                s3=et3.getText().toString();
                s4=et4.getText().toString();
                s5=et5.getText().toString();
                s6=et6.getText().toString();

                if(s1.equals("") || s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter Required Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    ContentValues cv = new ContentValues();
                    cv.put("Name", s1);
                    cv.put("Phone", s2);
                    cv.put("Email", s3);
                    cv.put("Person", s4);
                    cv.put("Date", s5);
                    cv.put("Time", s6);

                    bookid();
                    tablenum();
                       Intent i1=new Intent(getApplicationContext(),Main5Activity.class);
                        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,i1,0);
                        SmsManager sms=SmsManager.getDefault();
                        sms.sendTextMessage(s2,"+917011075009","Dear "+s1+"\nThanks For booking. Your Booking Id is: "+random+" Your Table Number is: "+tablenum+" Date is "+s5+"Time is "+s6,pi,null);
                    Toast.makeText(getApplicationContext(),"Dear "+s1+"\nThanks For booking. Your Booking Id is: "+random+" Your Table Number is: "+tablenum+" Date is "+s5+"Time is "+s6,Toast.LENGTH_LONG).show();
                    long l1 = db.insert("Book", null, cv);
                    if (l1 > 0) {
                        Toast.makeText(getApplicationContext(), "Table Booked", Toast.LENGTH_SHORT).show();

                        /* Intent i = new Intent(getApplicationContext(), Main6Activity.class);
                        startActivity(i)*/;
                    } else {
                        Toast.makeText(getApplicationContext(), "Database Connectivity Issue", Toast.LENGTH_SHORT).show();
                    }

                }    }
        });





}
public void bookid(){
    random=(int)Math.random()*100+100;
    }

    public void tablenum(){
        tablenum=(int)Math.random()*100+100;
    }
}
