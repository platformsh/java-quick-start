package sh.platform.template;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuantityDTO {

    @NotBlank
    private String unit;

    @NotNull
    private Number value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString() + ' ' + unit;
    }
}
