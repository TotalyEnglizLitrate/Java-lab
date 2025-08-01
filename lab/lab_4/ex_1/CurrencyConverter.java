package lab.lab_4.ex_1;

/**
 * Provides methods for currency conversion to and from INR.
 * Uses public methods for conversions and private constants for exchange rates.
 */
public class CurrencyConverter {

    private static final double USD_TO_INR_RATE = 83.25;
    private static final double EUR_TO_INR_RATE = 90.0;
    private static final double JPY_TO_INR_RATE = 0.55;

    public double usdToInr(double usd) {
        return usd * USD_TO_INR_RATE;
    }

    public double inrToUsd(double inr) {
        return inr / USD_TO_INR_RATE;
    }

    public double eurToInr(double eur) {
        return eur * EUR_TO_INR_RATE;
    }

    public double inrToEur(double inr) {
        return inr / EUR_TO_INR_RATE;
    }
    
    public double jpyToInr(double jpy) {
        return jpy * JPY_TO_INR_RATE;
    }
    
    public double inrToJpy(double inr) {
        return inr / JPY_TO_INR_RATE;
    }
}
