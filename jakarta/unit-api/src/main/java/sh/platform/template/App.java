package sh.platform.template;

import tech.units.indriya.quantity.Quantities;

import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.quantity.Length;

import static tech.units.indriya.unit.Units.METRE;

public class App {

    public static void main(String[] args) {

        Quantity<Length> distance = Quantities.getQuantity(1_000, METRE);
        Quantity<Length> distanceB = Quantities.getQuantity(54_000, METRE);
        final Quantity<Length> result = distance.add(distanceB);
        final Quantity<Length> kiloDistance = result.to(MetricPrefix.KILO(METRE));
        System.out.println(result);
        System.out.println(kiloDistance);

    }
}
