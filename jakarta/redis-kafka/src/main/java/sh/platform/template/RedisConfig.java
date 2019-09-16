package sh.platform.template;

import org.eclipse.jnosql.diana.redis.keyvalue.RedisBucketManagerFactory;
import org.eclipse.jnosql.diana.redis.keyvalue.RedisConfiguration;
import org.eclipse.jnosql.diana.redis.keyvalue.SortedSet;
import sh.platform.config.Config;
import sh.platform.config.Redis;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class RedisConfig {

    @Produces
    @ApplicationScoped
    public SortedSet redisConfig() {
        Config config = new Config();
        final Redis redis = config.getCredential("redis", Redis::new);
        RedisConfiguration configuration = new RedisConfiguration();
        final RedisBucketManagerFactory bucketFactory = configuration.get(redis.get());
        return bucketFactory.getSortedSet("names");
    }
}
