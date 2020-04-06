package sh.platform.template.config;

import org.modelmapper.AbstractConverter;
import sh.platform.template.QuantityDTO;

import javax.measure.Quantity;
import javax.measure.format.QuantityFormat;
import javax.measure.spi.ServiceProvider;

public class QuantityDTOQuantityConverter extends AbstractConverter<QuantityDTO, Quantity<?>> {

    private static final QuantityFormat FORMAT = ServiceProvider.current().getFormatService().getQuantityFormat();

    @Override
    protected Quantity<?> convert(QuantityDTO source) {
        if (source == null) {
            return null;
        }
        return FORMAT.parse(source.toString());
    }
}