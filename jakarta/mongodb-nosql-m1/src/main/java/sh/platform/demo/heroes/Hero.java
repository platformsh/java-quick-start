package sh.platform.demo.heroes;


import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import javax.json.bind.annotation.JsonbVisibility;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Hero implements Serializable {

    @Id
    private String name;

    @Column
    private Integer age;

    @Column
    private Set<String> powers;

    public Hero() {
    }

    public Hero(String name, Integer age, Set<String> powers) {
        this.name = name;
        this.age = age;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Hero)) {
            return false;
        }
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", powers=" + powers +
                '}';
    }
}
