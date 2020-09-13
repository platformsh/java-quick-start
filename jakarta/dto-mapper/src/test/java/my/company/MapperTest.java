package my.company;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapperTest {

    private UserMapper mapper;

    @BeforeEach
    public void init() {
        this.mapper = Mappers.getMapper(UserMapper.class);
    }

    @Test
    public void convertToUser() {
        UserDTO dto = new UserDTO();
        dto.setNickname("otaviojava");
        dto.setBirthday(LocalDate.now().toString());
        dto.setLanguages(Arrays.asList("Portuguese"));
        dto.setSalary("USD 10000");
        User user = mapper.toEntity(dto);

        assertEquals(dto.getNickname(), user.getNickname());
        assertEquals(Money.parse("USD 10000"), user.getSalary());
        assertEquals(LocalDate.now(), user.getBirthday());
    }

    @Test
    public void convertToDTO() {
        UserDTO dto = new UserDTO();
        dto.setNickname("otaviojava");
        dto.setBirthday(LocalDate.now().toString());
        dto.setLanguages(Arrays.asList("Portuguese"));
        dto.setSalary("USD 10000");
        User user = mapper.toEntity(dto);

        UserDTO userDTO = mapper.toDTO(user);
        Assertions.assertNotNull(userDTO);

        assertEquals(dto.getNickname(), userDTO.getNickname());
        assertEquals(dto.getSalary(), userDTO.getSalary());
        assertEquals(dto.getBirthday(), userDTO.getBirthday());
    }
}
