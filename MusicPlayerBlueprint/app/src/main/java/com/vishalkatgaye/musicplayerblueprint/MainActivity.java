package com.vishalkatgaye.musicplayerblueprint;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager_view);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_view);

        final ImageButton play = (ImageButton) findViewById(R.id.play_button);
        final ImageButton pause = (ImageButton) findViewById(R.id.pause_button);

        viewPager.setAdapter(new MusicFragmentPageAdapter(getSupportFragmentManager()));
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.indicator));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

//        This method will be used to play music via ImageButton
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Playing song! ", Toast.LENGTH_SHORT).show();
            }
        });

//        This method will be used to pause music via ImageButton
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play.setVisibility(View.VISIBLE);
                pause.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Song Paused! ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
