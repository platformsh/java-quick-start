package sh.platform.template;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

@Entity
public class Travel {

    @Column
    private String to;

    @Column
    private String from;

    @Column
    @Convert(LengthConverter.class)
    private Quantity<Length> distance;

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Quantity<Length> getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", distance=" + distance +
                '}';
    }
}
