package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new Fragment to be placed in the activity layout
        ForecastFragment f = new ForecastFragment();
        // Add the fragment to the 'container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(
                R.id.activity_weather, f).commit();

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
        Log.i(TAG, "+++++ App Stopped +++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "##### App Destroyed #####");
    }



}