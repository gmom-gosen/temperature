package jp.gmom.sample.temperature.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditNumber extends EditText {

    public boolean isTarget;

    @SuppressWarnings("UnusedDeclaration")
    public EditNumber(Context context) {
        super(context);
    }

    @SuppressWarnings("UnusedDeclaration")
    public EditNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setValue(double degrees) {
        this.setText(String.valueOf(degrees));
    }

    public double getValue() {
        return Double.parseDouble(this.getText().toString());
    }
}
