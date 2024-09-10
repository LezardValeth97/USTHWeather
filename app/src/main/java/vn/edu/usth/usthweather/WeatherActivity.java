package vn.edu.usth.usthweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.farout);
//        mp.setVolume(70,70);
        mp.start();
/*
        // Create a new Fragment to be placed in the activity layout
        ForecastFragment f = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(
                R.id.activity_weather, f).commit();
*/
        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tablayout = findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(pager);



        Log.i(TAG, "===== App Created =====");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "***** App Started *****");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "----- App Resumed -----");
    }

    @Override
    protected void onPause () {
        super.onPause();
        Log.i(TAG, "||||| App Paused |||||");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
        mp.release();
        Log.i(TAG, "+++++ App Stopped +++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "##### App Destroyed #####");
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private final String[] titles = new String[]{"Hanoi", "Paris", "Toulouse"};

        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;          // number of pages for a ViewPager
//            return (titles.length);   // number of pages for a ViewPager
        }

        @NonNull
        @Override
        public Fragment getItem(int page){
            // returns an instance of Fragment corresponding to the specified page
            return new WeatherAndForecastFragment();
        }

        @Override
        public CharSequence getPageTitle(int page) {
            // returns a tab title corresponding to the specified page
            return titles[page];
        }
    }

}