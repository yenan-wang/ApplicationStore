package com.example.applicationstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class GameFragment extends Fragment {
    private View contextView;
    private SearchView searchView;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private GameFragmentPagerAdapter gameFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contextView = inflater.inflate(R.layout.game_fragment, container, false);
        searchView = contextView.findViewById(R.id.search);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        initView();
        return contextView;
    }

    private void initView() {
        //使用适配器将ViewPager与Fragment绑定在一起
        viewPager = contextView.findViewById(R.id.game_viewpager);
        gameFragmentPagerAdapter = new GameFragmentPagerAdapter(getChildFragmentManager(), 3);
        viewPager.setAdapter(gameFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        tabLayout = contextView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //指定tab的位置
        one = tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(2);
    }
}
