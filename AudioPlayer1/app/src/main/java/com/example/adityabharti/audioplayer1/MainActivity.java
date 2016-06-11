package com.example.adityabharti.audioplayer1;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Prabu
 *
 */
public class MainActivity extends Activity implements OnClickListener{
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Button button1=(Button)findViewById(R.id.button_1);
        Button button2=(Button)findViewById(R.id.button_2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    public void onClick(View v) {
        int resId ;

        switch (v.getId()) {
            case R.id.button_1:
                resId = R.raw.a;
                break;

            case R.id.button_2:
                resId = R.raw.b;
            break;

            default:
                resId = R.raw.a;
                break;
        }
        // Release any resources from previous MediaPlayer
        if(mp != null) {
            mp.release();
        }
        // Create a new MediaPlayer to play this sound
        mp = MediaPlayer.create(this, resId);
            mp.start();

    }

    public void pauseit(View view)
    {
        mp.pause();
    }
    @Override
    protected void onDestroy(){
        if(null!=mp){
            mp.release();
        }
        super.onDestroy();
    }
}