package vn.edu.usth.usthweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
//    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mp = MediaPlayer.create(this, R.raw.farout);
//        mp.start();
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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Log.i(TAG, "===== App Created =====");
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "***** App Started *****");
    }

    @Override
    protected void onPause () {
        super.onPause();
        Log.i(TAG, "||||| App Paused |||||");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "----- App Resumed -----");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        mp.stop();
//        mp.release();
        Log.i(TAG, "+++++ App Stopped +++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "##### App Destroyed #####");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                return true;
            case R.id.action_settings:
                Intent myIntent = new Intent(this, PrefActivity.class);
                this.startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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