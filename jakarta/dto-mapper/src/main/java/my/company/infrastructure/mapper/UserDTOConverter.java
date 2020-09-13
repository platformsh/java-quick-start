package my.company.infrastructure.mapper;

import my.company.User;
import my.company.UserDTO;
import org.modelmapper.AbstractConverter;

import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class UserDTOConverter extends AbstractConverter<User, UserDTO> {

    @Override
    protected UserDTO convert(User source) {
        UserDTO dto = new UserDTO();

        dto.setNickname(source.getNickname());
        dto.setBirthday(ofNullable(source.getBirthday()).map(Object::toString).orElse(null));
        dto.setSalary(ofNullable(source.getSalary()).map(Object::toString).orElse(null));
        dto.setLanguages(new ArrayList<>(source.getLanguages()));
        dto.setSettings(new HashMap<>(source.getSettings()));
        return dto;
    }
}
