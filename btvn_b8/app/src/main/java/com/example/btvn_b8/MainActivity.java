package com.example.btvn_b8;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel viewModel;
    private SharedPreferences prefs;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);

        Button btnIncrement = findViewById(R.id.btnIncrement);
        Button btnDecrement = findViewById(R.id.btnDecrement);
        Button btnReset = findViewById(R.id.btnReset);

        prefs = getSharedPreferences(
                "counter_prefs",
                MODE_PRIVATE
        );

        viewModel = new ViewModelProvider(this)
                .get(CounterViewModel.class);

        viewModel.loadCount(prefs);

        viewModel.getCount().observe(this, count -> {
            tvCount.setText(String.valueOf(count));
        });

        btnIncrement.setOnClickListener(v ->
                viewModel.increment(prefs)
        );

        btnDecrement.setOnClickListener(v ->
                viewModel.decrement(prefs)
        );

        btnReset.setOnClickListener(v ->
                viewModel.reset(prefs)
        );

    }
}