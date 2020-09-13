package my.company;


import org.javamoney.moneta.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.money.MonetaryAmount;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "salary", target = "salary", qualifiedByName = "moneyString")
    UserDTO toDTO(User user);

    @Mapping(source = "salary", target = "salary", qualifiedByName = "money")
    User toEntity(UserDTO dto);

    @Named("money")
    static MonetaryAmount money(String money) {
        if (money == null) {
            return null;
        }
        return Money.parse(money);
    }

    @Named("moneyString")
    static String moneyString(MonetaryAmount money) {
        if (money == null) {
            return null;
        }
        return money.toString();
    }
}
