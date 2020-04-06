package sh.platform.template;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class TripDTO {

    @NotBlank
    private String trip;

    private List<String> friends;

    @NotBlank
    private String start;

    @NotBlank
    private String end;

    private List<TravelDTO> travels;

    private int totalDays;

    private QuantityDTO distance;

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<TravelDTO> getTravels() {
        return travels;
    }

    public void setTravels(List<TravelDTO> travels) {
        this.travels = travels;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public QuantityDTO getDistance() {
        return distance;
    }

    public void setDistance(QuantityDTO distance) {
        this.distance = distance;
    }
}
