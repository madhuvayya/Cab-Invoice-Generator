import org.junit.Assert;
import org.junit.Test;

public class RideRepositoryTest {

    RideRepository rideRepository = new RideRepository();

    @Test
    public void givenUserId_whenFound_shouldReturnRideList() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        rideRepository.addRides("abc@gmail.com",rides);
        Assert.assertEquals(rideRepository.getRides("abc@gmail.com").length,rides.length);
    }

    @Test
    public void givenUserId_whenNotFound_shouldReturnThrowException() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        rideRepository.addRides("abc@gmail.com",rides);
        try {
            int result = rideRepository.getRides("xyz@gmail.com").length;
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.INVALID_USER_ID, e.type);
        }
    }
}
