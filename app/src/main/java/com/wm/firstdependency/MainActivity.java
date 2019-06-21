package com.wm.firstdependency;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wm.firstependencies.CentralTendency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMessage = findViewById(R.id.textMessage);
        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 15; i++) {
            numbers.add(r.nextInt(7) + 1);
        }

        double mean = CentralTendency.arithmeticMean(numbers).doubleValue();
        double median = CentralTendency.median(numbers);
        ArrayList<Integer> mode = CentralTendency.mode(numbers);

        Collections.sort(numbers);

        @SuppressLint("DefaultLocale") String res = String.format("Numbers:\n\n%s\nMean: %.1f\nMedian: %.1f\nMode: %s\n",
                numbers, mean, median, mode);


        textMessage.setText(res);
    }
}
