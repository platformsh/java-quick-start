package sh.platform.template;


import org.aerogear.kafka.cdi.annotation.KafkaConfig;

@KafkaConfig(bootstrapServers = "#{kafka_host}:#{kafka_port}")
public class Config {

    static final String TOPIC = "topic";

    static final String GROUP_ID = "group";
}
