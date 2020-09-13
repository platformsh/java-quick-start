package my.company;


import org.javamoney.moneta.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "salary", target = "salary", qualifiedByName = "moneyString")
    @Mapping(source = "birthday", target = "birthday", qualifiedByName = "localDateString")
    @Mapping(source = "languages", target = "languages", qualifiedByName = "languages")
    UserDTO toDTO(User user);

    @Mapping(source = "salary", target = "salary", qualifiedByName = "money")
    @Mapping(source = "birthday", target = "birthday", qualifiedByName = "localDate")
    @Mapping(source = "languages", target = "languages", qualifiedByName = "languages")
    User toEntity(UserDTO dto);

    @Named("money")
    static MonetaryAmount money(String money) {
        if (money == null) {
            return null;
        }
        return Money.parse(money);
    }

    @Named("localDate")
    static LocalDate localDate(String date) {
        if (date == null) {
            return null;
        }
        return LocalDate.parse(date);
    }

    @Named("moneyString")
    static String moneyString(MonetaryAmount money) {
        if (money == null) {
            return null;
        }
        return money.toString();
    }

    @Named("localDateString")
    static String localDateString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }

    @Named("languages")
    static List<String> convert(List<String> languages) {
        if (languages == null) {
            return Collections.emptyList();
        }
        return languages.stream().collect(Collectors.toList());
    }
}
