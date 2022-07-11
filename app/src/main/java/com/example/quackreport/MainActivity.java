package com.example.quackreport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    /** URL to query the USGS dataset for earthquake information */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }
    private class EarthquakeAsyncTask extends AsyncTask<String, Void, ArrayList<Earthquake>>{

        @Override
        protected ArrayList<Earthquake> doInBackground(String... urlss) {
            // Perform the HTTP request for earthquake data and process the response.
           // String urls = (String) urlss;
            ArrayList<Earthquake> result = QueryUtils.fetchEarthquakeData(urlss[0]);
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> result) {
            // Update the information displayed to the user.
            updateUi(result);
        }
    }

    private void updateUi(ArrayList<Earthquake> result){
        ArrayList<Earthquake> eq=result;


        ListView listView=(ListView) findViewById(R.id.list);
        EarthquakeAdapter itemAdepter=new EarthquakeAdapter(this,R.layout.list_items,eq);
        listView.setAdapter(itemAdepter);

    }


}