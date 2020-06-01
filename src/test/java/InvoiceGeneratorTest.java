import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceGeneratorTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public RideRepository rideRepository;

    @InjectMocks
    public InvoiceService invoiceService;

    @Test
    public void givenDistanceAndTime_shouldReturnFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time, InvoiceService.FarePremium.NORMAL);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time, InvoiceService.FarePremium.NORMAL);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultiple_shouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides, InvoiceService.FarePremium.NORMAL);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIDAndRides_whenFareIsNormal_shouldReturnInvoiceSummaryForNormalFares() {
        String userId = "a@d.com";
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Mockito.when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId, InvoiceService.FarePremium.NORMAL);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIDAndRides_whenFareIsPremium_shouldReturnInvoiceSummaryForPremiumFares() {
        String userId = "a@d.com";
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        Mockito.when(rideRepository.getRides(ArgumentMatchers.any())).thenReturn(rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId, InvoiceService.FarePremium.PREMIUM);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}
