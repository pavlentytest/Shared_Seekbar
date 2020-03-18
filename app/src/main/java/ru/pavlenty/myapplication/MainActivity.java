package ru.pavlenty.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                shared = getSharedPreferences("baseSettings",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putInt("value",seekBar.getProgress());
                editor.apply();
                Snackbar.make(findViewById(R.id.root),"Saved!",Snackbar.LENGTH_LONG).show();
            }
        });


    }

    public void loadSettings() {
        shared = getSharedPreferences("baseSettings", Context.MODE_PRIVATE);
        if (shared != null) {
            int value = shared.getInt("value",1);
            seekBar.setProgress(value);
        }
    }
}
