import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {

    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides){
        this.userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
    }

    public Ride[] getRides(String userId){
        if(this.userRides.get(userId) == null)
            throw new RideRepositoryException("Invalid User Id", RideRepositoryException.ExceptionType.INVALID_USER_ID);
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
