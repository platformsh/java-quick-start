package my.company;

import my.company.infrastructure.mapper.MapperProducer;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelMapperTest {

    private ModelMapper mapper;

    @BeforeEach
    public void init() {
        MapperProducer producer = new MapperProducer();
        producer.init();
        this.mapper = producer.get();
    }

    @Test
    public void convertToUser() {
        UserDTO dto = new UserDTO();
        dto.setNickname("otaviojava");
        dto.setBirthday(LocalDate.now().toString());
        dto.setLanguages(Arrays.asList("Portuguese"));
        dto.setSalary("USD 10000");
        User user = mapper.map(dto, User.class);

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
        User user = mapper.map(dto, User.class);

        UserDTO userDTO = mapper.map(user, UserDTO.class);
        Assertions.assertNotNull(userDTO);

        assertEquals(dto.getNickname(), userDTO.getNickname());
        assertEquals(dto.getSalary(), userDTO.getSalary());
        assertEquals(dto.getBirthday(), userDTO.getBirthday());
    }
}
