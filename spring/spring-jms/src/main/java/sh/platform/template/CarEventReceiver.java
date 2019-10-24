package sh.platform.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CarEventReceiver {

    @Autowired
    private CarLogRepository repository;

    @JmsListener(destination = "new")
    public void newCar(Car car) {
        CarLog log = CarLog.newCar(car);
        repository.save(log);
    }

    @JmsListener(destination = "junk")
    public void junk(Car car) {
        CarLog log = CarLog.junk(car);
        repository.save(log);
    }

    @JmsListener(destination = "sold")
    public void sold(Car car) {
        CarLog log = CarLog.sold(car);
        repository.save(log);
    }
}