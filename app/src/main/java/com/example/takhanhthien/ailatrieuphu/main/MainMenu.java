package com.example.takhanhthien.ailatrieuphu.main;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.takhanhthien.ailatrieuphu.R;


public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private Button btnHelp;
    private Button btnExit;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        playSound(R.raw.bg_music);
        initView();
    }

    private void initView() {
        btnStart= (Button) findViewById(R.id.btn_batDau);
        btnHelp= (Button) findViewById(R.id.btn_troGiup);
        btnExit= (Button) findViewById(R.id.btn_thoat);
        btnStart.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_batDau:
                mediaPlayer.stop();
                playSound(R.raw.batdauchoi);
                Intent intent=new Intent(this, MainStart.class);
                startActivity(intent);
                break;
            case R.id.btn_troGiup:
                mediaPlayer.stop();
                Intent intent1=new Intent(this,MainHelp.class);
                startActivity(intent1);
                break;
            case R.id.btn_thoat:
                System.exit(0);
                break;
        }
    }

    public void playSound(int type){
        mediaPlayer = MediaPlayer.create(this, type);
        mediaPlayer.start();
    }
}
