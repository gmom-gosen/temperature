package jp.gmom.sample.temperature.tests;

import android.view.KeyEvent;

import java.util.HashMap;

public class KeyCodeConverter {
    private static final HashMap<Character, Integer> KEY_CODES = new HashMap<Character, Integer>();
    static {
        KEY_CODES.put('0', KeyEvent.KEYCODE_0);
        KEY_CODES.put('1', KeyEvent.KEYCODE_1);
        KEY_CODES.put('2', KeyEvent.KEYCODE_2);
        KEY_CODES.put('3', KeyEvent.KEYCODE_3);
        KEY_CODES.put('4', KeyEvent.KEYCODE_4);
        KEY_CODES.put('5', KeyEvent.KEYCODE_5);
        KEY_CODES.put('6', KeyEvent.KEYCODE_6);
        KEY_CODES.put('7', KeyEvent.KEYCODE_7);
        KEY_CODES.put('8', KeyEvent.KEYCODE_8);
        KEY_CODES.put('9', KeyEvent.KEYCODE_9);
        KEY_CODES.put('-', KeyEvent.KEYCODE_MINUS);
        KEY_CODES.put('.', KeyEvent.KEYCODE_PERIOD);
    }

    public static int[] convert(double number) {
        return convert(String.valueOf(number));
    }

    public static int[] convert(String str) {
        if (str == null ||  str.isEmpty())
            return new int[0];

        int[] converted = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Integer keyCode = KEY_CODES.get(key);
            if (keyCode == null) {
                throw new UnsupportedOperationException("Unknown key code for " + key);
            }
            converted[i] = keyCode;
        }

        return converted;
    }
}
