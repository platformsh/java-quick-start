package my.company.infrastructure.mapper;

import org.modelmapper.AbstractConverter;

import javax.money.MonetaryAmount;

public class MonetaryAmountStringConverter extends AbstractConverter<MonetaryAmount, String> {

    @Override
    protected String convert(MonetaryAmount source) {
        if (source == null) {
            return null;
        }
        return source.toString();
    }
}
