package com.snehpandya.ultimateandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Sneh on 31-05-2017.
 */

public class NetworkActivity extends AppCompatActivity {

    public static final String LOG_TAG = NetworkActivity.class.getSimpleName();
    private static final String REQUEST_URL = "https://docs-examples.firebaseio.com/rest/saving-data/fireblog/posts.json?print=pretty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        NetworkAsyncTask task = new NetworkAsyncTask();
        task.execute();
    }

    private void updateUri(Event json) {
        TextView authorTextview = (TextView) findViewById(R.id.author_text);
        authorTextview.setText(json.author);

        TextView titleTextview = (TextView) findViewById(R.id.title_text);
        titleTextview.setText(json.title);
    }

    private class NetworkAsyncTask extends AsyncTask<URL, Void, Event> {

        @Override
        protected Event doInBackground(URL... params) {
            URL url = createUrl(REQUEST_URL);
            String jsonResponse = "";
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {}

            Event response = extractFeatureFromJson(jsonResponse);

            return response;
        }

        @Override
        protected void onPostExecute(Event response) {
            if(response == null) {
                return;
            }
            updateUri(response);
        }

        private URL createUrl(String stringUrl) {
            URL url = null;
            try {
                url = new URL(stringUrl);
            } catch (MalformedURLException exception) {
                Log.e(LOG_TAG, "Error with creating URL", exception);
                return null;
            }
            return url;
        }

        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";

            if (url == null) {
                return jsonResponse;
            }
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG, "Error response code" +urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e(LOG_TAG,"Problem retrieving the JSON results", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }

        private Event extractFeatureFromJson(String JSON) {

            if (TextUtils.isEmpty(JSON)) {
                return null;
            }
            try {
                JSONObject baseJsonResponse = new JSONObject(JSON);
                JSONObject firstFeature = baseJsonResponse.getJSONObject("-JRHTHaIs-jNPLXOQivY");

                String title = firstFeature.getString("title");
                String author = firstFeature.getString("author");

                return new Event(author, title);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return null;
        }
        }

    }