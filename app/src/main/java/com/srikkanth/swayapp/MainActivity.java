package com.srikkanth.swayapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mGreetingView, mVideosView, mPhotoGalleryView;
    ImageView imgHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgHappy = (ImageView) findViewById(R.id.imgHappy);
        if(imgHappy != null)
        imgHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Snackbar.make(view, "Happy Birthday !!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///android_asset/video.mp4"));
                intent.setDataAndType(Uri.parse("file:///android_asset/video.mp4"), "video/mp4");*/


//                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });

        mGreetingView = (RelativeLayout) findViewById(R.id.layoutGreeting);
        mGreetingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GreetingCardActivity.class));
            }
        });

        /*mPhotoGalleryView = (RelativeLayout) findViewById(R.id.layoutPhotos);
        mPhotoGalleryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "card tapped", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
