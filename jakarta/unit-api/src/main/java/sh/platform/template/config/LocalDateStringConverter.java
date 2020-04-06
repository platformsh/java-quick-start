package sh.platform.template.config;

import org.modelmapper.AbstractConverter;

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