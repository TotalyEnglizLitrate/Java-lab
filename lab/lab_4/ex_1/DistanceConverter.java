package lab.lab_4.ex_1;

/**
 * Provides methods for distance conversion.
 */
public class DistanceConverter {
    protected static final double METERS_IN_KM = 1000.0;
    
    private static final double MILES_IN_KM = 1.60934;

    public double metersToKm(double meters) {
        return meters / METERS_IN_KM;
    }

    public double kmToMeters(double km) {
        return km * METERS_IN_KM;
    }

    public double milesToKm(double miles) {
        return miles * MILES_IN_KM;
    }

    public double kmToMiles(double km) {
        return km / MILES_IN_KM;
    }
}

