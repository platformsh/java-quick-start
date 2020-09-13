package my.company;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import my.company.infrastructure.MonetaryAmountAttributeConverter;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class User {

    @Id
    private String nickname;

    @Column
    @Convert(MonetaryAmountAttributeConverter.class)
    private MonetaryAmount salary;

    @Column
    private List<String> languages;

    @Column
    private LocalDate birthday;

    @Column
    private Map<String, String> settings;

    public String getNickname() {
        return nickname;
    }

    public MonetaryAmount getSalary() {
        return salary;
    }

    public void setSalary(MonetaryAmount salary) {
        this.salary = salary;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<String> getLanguages() {
        if (languages == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(languages);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Map<String, String> getSettings() {
        if (settings == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(settings);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", salary=" + salary +
                ", languages=" + languages +
                ", birthday=" + birthday +
                ", settings=" + settings +
                '}';
    }
}
