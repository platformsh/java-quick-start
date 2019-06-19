package sh.platform.template;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import sh.platform.config.Config;
import sh.platform.config.MySQL;
import sh.platform.config.Redis;
import sh.platform.config.RedisSpring;

import javax.sql.DataSource;

@Configuration
public class JedisConfig {

    @Bean
    public JedisConnectionFactory getDataSource() {
        Config config = new Config();
        RedisSpring redis = config.getCredential("redis", RedisSpring::new);
        return redis.get();
    }
}
