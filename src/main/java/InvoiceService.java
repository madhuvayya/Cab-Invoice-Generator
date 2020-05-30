public class InvoiceService {

    enum FarePremium {
        NORMAL,
        PREMIUM
    }

    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time, FarePremium farePremium) {
        FaresFactory faresFactory = new FaresFactory();
        Fares fares1 = faresFactory.getFares(farePremium);
        double fare  = (fares1.RATE_PER_KILOMETER * distance) + (fares1.RATE_PER_MINUTE * time);
        return Math.max(fare, fares1.MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides,FarePremium farePremium) {
        double totalFare = 0.0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time,farePremium);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId,FarePremium farePremium) {
        return this.calculateFare(rideRepository.getRides(userId),farePremium);
    }
}
