package jp.gmom.sample.temperature;

public class TemperatureConverter {
    public static double FAHRENHEIT_FREEZING_POINT = 32.0;
    public static double FAHRENHEIT_BOILING_POINT = 212.0;

    public static double CELSIUS_FREEZING_POINT = 0.0;
    public static double CELSIUS_BOILING_POINT = 100.0;

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_FREEZING_POINT) * 5/9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9/5 + FAHRENHEIT_FREEZING_POINT;
    }
}
