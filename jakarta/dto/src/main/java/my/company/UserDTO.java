package my.company;

import java.util.List;
import java.util.Map;

public class UserDTO {

    private String nickname;

    private String salary;

    private List<String> languages;

    private String birthday;

    private Map<String, String> settings;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nickname='" + nickname + '\'' +
                ", salary='" + salary + '\'' +
                ", languages=" + languages +
                ", birthday='" + birthday + '\'' +
                ", settings=" + settings +
                '}';
    }
}
