package my.company.infrastructure.mapper;

import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.function.Supplier;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@ApplicationScoped
public class MapperProducer implements Supplier<ModelMapper> {

    private ModelMapper mapper;

    @PostConstruct
    public void init() {
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        this.mapper.addConverter(new StringMonetaryAmountConverter());
        this.mapper.addConverter(new MonetaryAmountStringConverter());
        this.mapper.addConverter(new StringLocalDateConverter());
        this.mapper.addConverter(new LocalDateStringConverter());
        this.mapper.addConverter(new UserDTOConverter());
    }


    @Override
    @Produces
    public ModelMapper get() {
        return mapper;
    }
}
