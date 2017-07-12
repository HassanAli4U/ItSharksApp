package com.iloveallah.itsharks.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.iloveallah.itsharks.R;


public class ContactActivity extends AppCompatActivity {
    private ImageButton face;
    private ImageButton google;
    private Button phone;
    private Button phone2;
    private Button phone3;
    private TextView num1, num2, num3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        face = (ImageButton) findViewById(R.id.face);
        google = (ImageButton) findViewById(R.id.google);


        phone = (Button) findViewById(R.id.phone);
        phone2 = (Button) findViewById(R.id.phone2);
        phone3 = (Button) findViewById(R.id.phone3);


        num1 = (TextView) findViewById(R.id.mobile);
        num1.setText(R.string.phone1);
        num2 = (TextView) findViewById(R.id.mobile2);
        num2.setText(R.string.phone2);
        num3 = (TextView) findViewById(R.id.mobile3);
        num3.setText(R.string.phone3);


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Uri uri = Uri.parse("tel:" + num1.getText().toString().trim());
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Uri uri = Uri.parse("tel:" + num2.getText().toString().trim());
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        phone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Uri uri = Uri.parse("tel:" + num3.getText().toString().trim());
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri web = Uri.parse("https://www.facebook.com/ITSharks");
                i.setData(web);
                startActivity(i);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri web = Uri.parse("https://plus.google.com/+ITSharksTrainingCenterCairo");
                i.setData(web);
                startActivity(i);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.courses: {
                Intent i = new Intent(getApplicationContext(), CoursesActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.instruct: {
                Intent i = new Intent(getApplicationContext(), InstructorsActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.reviews: {
                Intent i = new Intent(getApplicationContext(), ReviewTabsActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.location: {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://maps.google.com/maps?q=29.961962,31.250072");
                i.setData(uri);
                startActivity(i);
                return true;
            }
            case R.id.contact: {
                getCallingActivity();
                return true;
            }
            default: {
                Toast.makeText(ContactActivity.this,R.string.error, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_in_bottom);
    }
}
