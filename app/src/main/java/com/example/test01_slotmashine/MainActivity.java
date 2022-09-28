package com.example.test01_slotmashine;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    int cherry = 0x1F352;
    int orange = 0x1F34A;
    int grapes = 0x1F347;

    int[] fruits = {cherry, orange, grapes};

    private TextView[] cells;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        cells = new TextView[] {
            findViewById(R.id.textView00),
            findViewById(R.id.textView01),
            findViewById(R.id.textView02),
            findViewById(R.id.textView10),
            findViewById(R.id.textView11),
            findViewById(R.id.textView12),
            findViewById(R.id.textView20),
            findViewById(R.id.textView21),
            findViewById(R.id.textView22)
        };

        button.setOnClickListener(v -> {

            for (TextView cell : cells) {
                int idx = new Random().nextInt(fruits.length);
                cell.setText(getEmojiByUnicode(fruits[idx]));
            }
        });

        imageView = findViewById(R.id.imageView);
        setDrawable();

    }

    private void setDrawable() {
        imageView.setImageResource(R.drawable.shape);
    }
}