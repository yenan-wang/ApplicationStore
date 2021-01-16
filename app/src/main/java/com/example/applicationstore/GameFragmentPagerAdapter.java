package com.example.applicationstore;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GameFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] gameTabTitle = {"精选", "分类", "热门"};

    public GameFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new GameSecondFragment();
        } else if (position == 2) {
            return new GameThirdFragment();
        }
        return new GameFirstFragment();
    }

    @Override
    public int getCount() {
        return gameTabTitle.length;
    }

    //ViewPager与Tablayout绑定后，在这里获取到PageTitle，就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return gameTabTitle[position];
    }
}
