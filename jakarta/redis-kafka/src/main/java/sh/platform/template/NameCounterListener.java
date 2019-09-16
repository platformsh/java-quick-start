package sh.platform.template;

import org.aerogear.kafka.cdi.annotation.Consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NameCounterListener {

    @Inject
    private NameCounter counter;

    @Consumer(topics = Config.TOPIC, groupId = Config.GROUP_ID)
    public void receiver(final String name) {
        counter.count(name);
    }

}
