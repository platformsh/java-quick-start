package sh.platform.template.config;

import org.modelmapper.AbstractConverter;
import sh.platform.template.QuantityDTO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;

public class DistanceQuantityDTOConverter extends AbstractConverter<Quantity<?>, QuantityDTO> {

    @Override
    protected QuantityDTO convert(Quantity<?> source) {
        if (source == null) {
            return null;
        }
        final Number value = source.getValue();
        final Unit<Length> unit = (Unit<Length>) source.getUnit();
        QuantityDTO dto = new QuantityDTO();
        dto.setValue(value);
        dto.setUnit(unit.toString());
        return dto;
    }
}