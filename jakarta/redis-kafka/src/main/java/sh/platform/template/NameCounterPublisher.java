package sh.platform.template;

import org.aerogear.kafka.SimpleKafkaProducer;
import org.aerogear.kafka.cdi.annotation.Producer;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import java.util.logging.Logger;

@ApplicationScoped
public class NameCounterPublisher {

    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());
    @Producer
    private SimpleKafkaProducer<Integer, String> producer;

    public <T> void sendMessage(String name) {
        LOGGER.info("received the name " + name);
        producer.send(Config.TOPIC, name);
    }

}
