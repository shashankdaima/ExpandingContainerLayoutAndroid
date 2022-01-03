package com.example.demoexpandinglayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private static final String[] TAB_TITLES = {
            "Simple",
            "Accordion",
            "Recycler",
            "Horizontal",
            "Manual",
            "MyView"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new simpleAdapter(getSupportFragmentManager()));

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);
    }

    private class simpleAdapter extends FragmentPagerAdapter {
        public simpleAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return TAB_TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SimpleFragment();
                case 1:
                    return new AccordionFragment();
                case 2:
                    return new RecyclerViewFragment();
                case 3:
                    return new HorizontalFragment();
                case 4:
                    return new ManualFragment();
                case 5:
                    return new MyView();
            }

            throw new IllegalStateException("There's no fragment for position " + position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_TITLES[position];
        }
    }
}