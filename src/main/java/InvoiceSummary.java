public class InvoiceSummary {
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numberOfRides;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if( object ==null || getClass() != object.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) object;
        return numberOfRides == that.numberOfRides &&
                Double.compare(that.totalFare,totalFare) == 0 &&
                Double.compare(that.averageFare,averageFare) == 0;
    }
}
