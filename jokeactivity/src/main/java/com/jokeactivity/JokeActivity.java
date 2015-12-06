package com.jokeactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = JokeActivity.class.getName() + ".MESSAGE";

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeTextView = (TextView) findViewById(R.id.joke_text_view);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(EXTRA_MESSAGE);

        jokeTextView.setText(joke);
    }


}
