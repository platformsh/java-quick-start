package my.company.infrastructure.mapper;

import org.javamoney.moneta.Money;
import org.modelmapper.AbstractConverter;

import javax.money.MonetaryAmount;

public class StringMonetaryAmountConverter extends AbstractConverter<String, MonetaryAmount> {

    @Override
    protected MonetaryAmount convert(String source) {
        if (source == null) {
            return null;
        }
        return Money.parse(source);
    }
}
