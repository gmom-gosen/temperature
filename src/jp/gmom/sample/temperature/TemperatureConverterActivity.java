package jp.gmom.sample.temperature;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import jp.gmom.sample.temperature.view.EditNumber;

public class TemperatureConverterActivity extends Activity {
    private EditNumber celsius;
    private EditNumber fahrenheit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        celsius = (EditNumber) findViewById(R.id.celsius);
        fahrenheit = (EditNumber) findViewById(R.id.fahrenheit);

        celsius.setOnTouchListener(new OnClickListener(fahrenheit));
        fahrenheit.setOnTouchListener(new OnClickListener(celsius));

        findViewById(R.id.convert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });
    }

    private void convert() {
        if (isTarget(celsius)) {
            fahrenheit.setValue(TemperatureConverter.celsiusToFahrenheit(celsius.getValue()));
        } else if (isTarget(fahrenheit)) {
            celsius.setValue(TemperatureConverter.fahrenheitToCelsius(fahrenheit.getValue()));
        }
    }

    private boolean isTarget(EditNumber editNumber) {
        return (! editNumber.getText().toString().isEmpty()) && editNumber.isTarget;
    }

    private class OnClickListener implements View.OnTouchListener {

        final private EditNumber other;

        OnClickListener(EditNumber other) {
            this.other = other;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditNumber me = (EditNumber)view;
            me.isTarget = true;
            other.isTarget = false;

            celsius.getText().clear();
            fahrenheit.getText().clear();
            return false;
        }
    }
}
