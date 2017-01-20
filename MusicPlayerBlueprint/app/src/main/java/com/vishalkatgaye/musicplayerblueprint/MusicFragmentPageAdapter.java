package com.vishalkatgaye.musicplayerblueprint;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ViSh on 20-01-2017.
 */

public class MusicFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Songs", "Artists", "Albums", "Playlist"};

    public MusicFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    //    Shows tab description and increase or decrease their position.
    @Override
    public Fragment getItem(int position) {
        String describe = null;
        if (position == 0)
            describe = "It will display songs list";
        if (position == 1)
            describe = "It will display artist list";
        if (position == 2)
            describe = "It will display albums";
        if (position == 3)
            describe = "It will display playlist";
        return MusicFragment.newInstance(position + 1, describe);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}