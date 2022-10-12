package com.example.test01_slotmashine;

import android.widget.TextView;
import java.util.Random;

public class RandomValue {

    public String getEmojiByUnicode(int unicode){return new String(Character.toChars(unicode));}

    int[] fruitsUnicode = {0x1F352, 0x1F34A, 0x1F347};

    public void randomValue (TextView[] cells, Integer[] cellsIndexes) {
        for (int i = 0; i<cells.length; i++) {
            int idx = new Random().nextInt(fruitsUnicode.length);
            cells[i].setText(getEmojiByUnicode(fruitsUnicode[idx]));
            cellsIndexes[i] = idx;
        }
    }
}
