package sh.platform.template;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.Set;

@Document
public class God {

    @Id
    private String name;

    private Integer age;

    private Set<String> powers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<String> getPowers() {
        return powers;
    }

    public void setPowers(Set<String> powers) {
        this.powers = powers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        God god = (God) o;
        return Objects.equals(name, god.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "God{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", powers=" + powers +
                '}';
    }
}
