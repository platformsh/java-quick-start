package my.company.infrastructure.mapper;

import org.modelmapper.AbstractConverter;

import java.time.LocalDate;

public class StringLocalDateConverter extends AbstractConverter<String, LocalDate> {

    @Override
    protected LocalDate convert(String source) {
        if (source == null) {
            return null;
        }
        return LocalDate.parse(source);
    }
}
