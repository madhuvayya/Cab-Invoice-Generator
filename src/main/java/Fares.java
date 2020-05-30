public class Fares {
    public double RATE_PER_KILOMETER;
    public double RATE_PER_MINUTE ;
    public double MINIMUM_FARE ;

    public Fares() {
    }

    public Fares(double ratePerKilometer, double ratePerMinute, double minimumFare) {
        this.RATE_PER_KILOMETER = ratePerKilometer;
        this.RATE_PER_MINUTE = ratePerMinute;
        this.MINIMUM_FARE = minimumFare;
    }
}
