package sh.platform.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import sh.platform.template.config.MapperProducer;

import java.time.LocalDate;
import java.util.Arrays;

public class ConverterTest {

    private ModelMapper mapper;

    private MapperProducer producer = new MapperProducer();

    @BeforeEach
    public void setUp() {
        producer.init();
        this.mapper = producer.get();
    }

    @Test
    public void shouldConvertToEntity() {
        TripDTO tripDTO = getTripDTO();

        final Trip trip = mapper.map(tripDTO, Trip.class);
        Assertions.assertNotNull(trip);
    }

    @Test
    public void shouldConvertToDTO() {
        TripDTO tripDTO = getTripDTO();
        final Trip trip = mapper.map(tripDTO, Trip.class);
        TripDTO dto = mapper.map(trip, TripDTO.class);
        Assertions.assertNotNull(dto);
    }

    private TripDTO getTripDTO() {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setEnd(LocalDate.now().toString());
        tripDTO.setTrip("euro-trip-2019");
        tripDTO.setStart(LocalDate.now().minusDays(4).toString());
        tripDTO.setFriends(Arrays.asList("Bruno", "Edson", "Otavio"));
        QuantityDTO distance = new QuantityDTO();
        distance.setUnit("km");
        distance.setValue(9496.92);
        TravelDTO travelDTO = new TravelDTO();
        travelDTO.setTo("London");
        travelDTO.setFrom("São Paulo");
        travelDTO.setDistance(distance);
        tripDTO.setTravels(Arrays.asList(travelDTO));
        return tripDTO;
    }
}
