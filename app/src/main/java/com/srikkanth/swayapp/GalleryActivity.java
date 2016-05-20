package com.srikkanth.swayapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.MediaController;
import android.widget.VideoView;

public class GalleryActivity extends AppCompatActivity {

    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mVideoView = (VideoView) findViewById(R.id.videoView);
        /*
         * Alternatively, you can use mVideoView.setVideoPath(<path>);
         */
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +
                "/" + R.raw.video));
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.requestFocus();
        mVideoView.start();


    }

}
