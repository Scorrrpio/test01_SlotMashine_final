package com.example.test01_slotmashine;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckLines check = new CheckLines();
    RandomValue randomFruit = new RandomValue();
    int totalS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();

        int placeHolderColor = resources.getColor(R.color.placeHolderColor);
        int background = resources.getColor(R.color.background);

        Animation blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        Button button = findViewById(R.id.runButton);

        TextView lineD1 = findViewById(R.id.textLineDia1);
        TextView lineD2 = findViewById(R.id.textLineDia2);
        TextView lineUp = findViewById(R.id.textLineUp);
        TextView lineCenter = findViewById(R.id.textLineCenter);
        TextView lineDown = findViewById(R.id.textLineDown);

        TextView roundScoreLabel = findViewById(R.id.roundScoreLabel);
        TextView roundScore = findViewById(R.id.roundScore);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);
        TextView totalScore = findViewById(R.id.totalScore);

        Integer[] cellsIndexes = new Integer[9]; // индексы ячеек



        TextView[] cells = new TextView[] {
                findViewById(R.id.textView00),findViewById(R.id.textView01),
                findViewById(R.id.textView02),findViewById(R.id.textView10),
                findViewById(R.id.textView11),findViewById(R.id.textView12),
                findViewById(R.id.textView20),findViewById(R.id.textView21),
                findViewById(R.id.textView22)
        };

        button.setOnClickListener(v -> {
            lineUp.setTextColor(placeHolderColor);
            lineCenter.setTextColor(placeHolderColor);
            lineDown.setTextColor(placeHolderColor);
            lineD1.setTextColor(placeHolderColor);
            lineD2.setTextColor(placeHolderColor);
            roundScore.setTextColor(placeHolderColor);
            roundScoreLabel.setTextColor(background);
            totalScoreLabel.setTextColor(background);

            totalS += check.roundS/9;

            for (TextView cell : cells) {
                check.roundS = 0;

                cell.setShadowLayer(35, 0, 0, Color.TRANSPARENT);
                cell.clearAnimation();
                ObjectAnimator rotateCell = ObjectAnimator.ofFloat(cell, View.ROTATION_X, 0f, 1440f);

                rotateCell.setInterpolator(new AccelerateDecelerateInterpolator());
                rotateCell.setDuration(600);
                rotateCell.start();

                randomFruit.randomValue(cells, cellsIndexes);

                rotateCell.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        check.checkLines(cells, cellsIndexes, lineUp, lineCenter, lineDown, lineD1, lineD2, blink);

                        roundScore.setText(String.valueOf(check.roundS/9));
                        totalScore.setText(String.valueOf(totalS));

                        if (check.roundS != 0) {
                            roundScore.setTextColor(Color.YELLOW);
                        }
                        if (totalS != 0) {
                            totalScore.setTextColor(Color.CYAN);
                        }

                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {}
                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });

            }

        });
    }
}

