package sh.platform.template;

import jakarta.nosql.mapping.AttributeConverter;

import javax.measure.Quantity;
import javax.measure.format.QuantityFormat;
import javax.measure.quantity.Length;
import javax.measure.spi.ServiceProvider;

public class LengthConverter implements AttributeConverter<Quantity<Length>, String> {

    private static final QuantityFormat FORMAT = ServiceProvider.current().getFormatService().getQuantityFormat();

    @Override
    public String convertToDatabaseColumn(Quantity<Length> attribute) {
        if (attribute == null) {
            return null;
        }
        return FORMAT.format(attribute);
    }

    @Override
    public Quantity<Length> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return (Quantity<Length>) FORMAT.parse(dbData);
    }
}
