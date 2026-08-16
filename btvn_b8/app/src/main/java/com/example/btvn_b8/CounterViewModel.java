package com.example.btvn_b8;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    private static final String PREFS_NAME = "counter_prefs";
    private static final String KEY_COUNT = "count";

    private final MutableLiveData<Integer> count =
            new MutableLiveData<>(0);

    public LiveData<Integer> getCount() {
        return count;
    }

    public void loadCount(SharedPreferences prefs) {
        int savedCount = prefs.getInt(KEY_COUNT, 0);
        count.setValue(savedCount);
    }

    public void increment(SharedPreferences prefs) {
        int currentCount = count.getValue() != null
                ? count.getValue()
                : 0;

        int newCount = currentCount + 1;

        count.setValue(newCount);
        saveCount(prefs, newCount);
    }

    public void decrement(SharedPreferences prefs) {
        int currentCount = count.getValue() != null
                ? count.getValue()
                : 0;

        int newCount = Math.max(0, currentCount - 1);

        count.setValue(newCount);
        saveCount(prefs, newCount);
    }

    public void reset(SharedPreferences prefs) {
        count.setValue(0);
        saveCount(prefs, 0);
    }

    private void saveCount(SharedPreferences prefs, int value) {
        prefs.edit()
                .putInt(KEY_COUNT, value)
                .apply();
    }
}