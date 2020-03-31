package my.company.infrastructure.mapper;

import org.modelmapper.AbstractConverter;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class LocalDateStringConverter extends AbstractConverter<LocalDate, String> {

    @Override
    protected String convert(LocalDate source) {
        if (source == null) {
            return null;
        }
        return source.toString();
    }
}
