package sh.platform.template;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarLogRepository extends PagingAndSortingRepository<CarLog, Long> {

    List<CarLog> findByPlate(String plate);

    List<CarLog> findByModel(String model);

    List<CarLog> findByStatus(CarStatus status);
}