package sh.platform.template;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String plate;

    @Column
    private String model;

    @Column
    private Integer age;

    @Column
    private String color;

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getPlate() {
        return plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", model='" + model + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
