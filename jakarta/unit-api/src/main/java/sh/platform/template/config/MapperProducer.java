package sh.platform.template.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.function.Supplier;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@ApplicationScoped
public class MapperProducer implements Supplier<ModelMapper> {

    private ModelMapper mapper;

    @Inject
    public void init() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        this.mapper.addConverter(new StringLocalDateConverter());
        this.mapper.addConverter(new LocalDateStringConverter());
        this.mapper.addConverter(new DistanceQuantityDTOConverter());
        this.mapper.addConverter(new QuantityDTOQuantityConverter());
    }


    @Override
    @Produces
    public ModelMapper get() {
        return mapper;
    }
}