package lab.lab_4.ex_1;

/**
 * Provides methods for time conversion.
 */
public class TimeConverter {
    public double hoursToMinutes(double hours) {
        return hours * 60;
    }

    public double minutesToHours(double minutes) {
        return minutes / 60;
    }

    public double minutesToSeconds(double minutes) {
        return minutes * 60;
    }

    public double secondsToMinutes(double seconds) {
        return seconds / 60;
    }
}

