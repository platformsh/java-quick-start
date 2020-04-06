package sh.platform.template;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TravelDTO {

    @NotBlank
    private String to;

    @NotBlank
    private String from;

    @NotNull
    private QuantityDTO distance;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public QuantityDTO getDistance() {
        return distance;
    }

    public void setDistance(QuantityDTO distance) {
        this.distance = distance;
    }
}
