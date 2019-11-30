package sh.platform.template;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import sh.platform.config.Config;
import sh.platform.config.RabbitMQ;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JMSConfig {

    private ConnectionFactory getConnectionFactory() {
        Config config = new Config();
        final RabbitMQ rabbitMQ = config.getCredential("rabbitmq", RabbitMQ::new);
        return rabbitMQ.get();
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        ConnectionFactory connectionFactory = getConnectionFactory();
        return new CachingConnectionFactory(connectionFactory);
    }
}