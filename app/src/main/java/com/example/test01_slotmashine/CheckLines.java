package com.example.test01_slotmashine;

import android.graphics.Color;
import android.view.animation.Animation;
import android.widget.TextView;

public class CheckLines {

    int roundS = 0;
    int totalS = 0;

    public void checkLines (
            TextView[] text,
            Integer[] index,
            TextView lineUp,
            TextView lineCenter,
            TextView lineDown,
            TextView lineD1,
            TextView lineD2,
            Animation animation,
            TextView roundScore,
            TextView totalScore) {

        if (index[0].equals(index[1]) && index[1].equals(index[2])){
            for (int i = 0; i < 3; i++) {
                text[i].setAnimation(animation);
                lineUp.setTextColor(Color.BLUE);
                text[i].setShadowLayer(25,0,0,Color.BLUE);
            }
            roundS += 2;
            totalS += roundS;
        } else
        if (index[3].equals(index[4]) && index[4].equals(index[5])) {
            for (int i = 3; i < 6; i++) {
                text[i].setAnimation(animation);
                lineCenter.setTextColor(Color.RED);
                text[i].setShadowLayer(25,0,0,Color.RED);
            }
            roundS += 3;
            totalS += roundS;
        } else
        if (index[6].equals(index[7]) && index[7].equals(index[8])) {
            for (int i = 6; i < 9; i++) {
                text[i].setAnimation(animation);
                lineDown.setTextColor(Color.GREEN);
                text[i].setShadowLayer(25,0,0,Color.GREEN);
            }
            roundS += 2;
            totalS += roundS;
        }else
        if (index[0].equals(index[4]) && index[4].equals(index[8])) {
            for (int i = 0; i<9; i += 4) {
                text[i].setAnimation(animation);
                lineD1.setTextColor(Color.YELLOW);
                text[i].setShadowLayer(25,0,0,Color.YELLOW);
            }
            roundS += 1;
            totalS += roundS;
        }else
        if (index[6].equals(index[4]) && index[4].equals(index[2])) {
            for (int i = 2; i<7; i += 2) {
                text[i].setAnimation(animation);
                lineD2.setTextColor(Color.CYAN);
                text[i].setShadowLayer(25,0,0,Color.CYAN);
            }
            roundS += 1;
            totalS += roundS;
        }
        roundScore.setText(String.valueOf(roundS/9));
        totalScore.setText(String.valueOf(totalS/9));
    }

}
