package sh.platform.template;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Trip {

    @Id
    private String trip;

    @Column
    private List<String> friends;

    @Column
    private LocalDate start;

    @Column
    private LocalDate end;

    @Column
    private List<Travel> travels;

    public Quantity<Length> getDistance() {
        return getTravels()
                .stream()
                .map(Travel::getDistance)
                .reduce((a, b) -> a.add(b))
                .orElse(Quantities.getQuantity(0, Units.METRE));
    }

    public long getTotalDays() {
        return ChronoUnit.DAYS.between(start, end);
    }

    public String getTrip() {
        return trip;
    }

    public List<String> getFriends() {
        return friends;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public List<Travel> getTravels() {
        if (this.travels == null) {
            return Collections.emptyList();
        }
        return travels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trip trip1 = (Trip) o;
        return Objects.equals(trip, trip1.trip);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(trip);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "trip='" + trip + '\'' +
                ", friends=" + friends +
                ", start=" + start +
                ", end=" + end +
                ", travels=" + travels +
                '}';
    }
}
