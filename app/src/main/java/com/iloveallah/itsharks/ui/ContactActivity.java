package com.iloveallah.itsharks.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import ru.dimorinny.floatingtextbutton.FloatingTextButton;


public class ContactActivity extends AppCompatActivity {
    private ImageButton face;
    private ImageButton google;
    private ImageButton youTube;
    private FloatingTextButton phone;
    private FloatingTextButton whatsapp;
    private FloatingTextButton mail;
    private FloatingTextButton location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        face = (ImageButton) findViewById(R.id.face);
        google = (ImageButton) findViewById(R.id.google);
        youTube = (ImageButton) findViewById(R.id.yotube);


        phone = (FloatingTextButton) findViewById(R.id.phone);
        whatsapp = (FloatingTextButton) findViewById(R.id.whats);
        mail = (FloatingTextButton) findViewById(R.id.mail);
        location = (FloatingTextButton) findViewById(R.id.location);



        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://maps.google.com/maps?q=29.961962,31.250072");
                i.setData(uri);
                startActivity(i);

            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Uri uri = Uri.parse("tel:" + phone.getTitle().toString().trim());
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openWhatsApp(view);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("info@itsharks.co"));
                intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                intent.putExtra(Intent.EXTRA_CC, new String[]{"info@itsharks.co"});
                intent.putExtra(Intent.EXTRA_BCC, new String[]{""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "");
                intent.putExtra(Intent.EXTRA_TEXT, "");

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

        youTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                try {
                    intent =new Intent(Intent.ACTION_VIEW);
                    intent.setPackage("com.google.android.youtube");
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCd4x-LGET6qIqqI4cKj9thg"));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCd4x-LGET6qIqqI4cKj9thg"));
                    startActivity(intent);
                }
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

    public void openWhatsApp(View view){
        PackageManager pm=getPackageManager();
        try {


            String toNumber = "20"+R.string.phone2; // Replace with mobile phone number without +Sign or leading zeros, but with country code.
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.



            Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber+ "?body=" + ""));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(ContactActivity.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

        }
    }

}
