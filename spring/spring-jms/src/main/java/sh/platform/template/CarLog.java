package sh.platform.template;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

@Entity
public class CarLog {

    private static final ZoneId UTC = ZoneId.of("UTC");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String plate;

    @Column
    private String model;

    @Column
    private LocalDateTime date = LocalDateTime.now(UTC);

    @Column
    @Enumerated(value = EnumType.STRING)
    private CarStatus status;

    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public CarStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static CarLog newCar(Car car) {
        return of(car, CarStatus.NEW);
    }

    public static CarLog junk(Car car) {
        return of(car, CarStatus.JUNK);
    }

    public static CarLog sold(Car car) {
        return of(car, CarStatus.SOLD);
    }

    private static CarLog of(Car car, CarStatus status) {
        Objects.requireNonNull(car, "car is required");
        CarLog log = new CarLog();
        log.plate = car.getPlate();
        log.model = car.getModel();
        log.status = status;
        return log;
    }
}
