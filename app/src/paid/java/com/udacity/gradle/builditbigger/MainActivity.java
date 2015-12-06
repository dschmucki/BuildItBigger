package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.jokeactivity.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(this);
    }

    public void showJoke(final String joke) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_MESSAGE, joke);
        this.startActivity(intent);
        progressBar.setVisibility(View.GONE);
    }
}
