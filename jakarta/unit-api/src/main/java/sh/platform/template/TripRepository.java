package sh.platform.template;

import jakarta.nosql.mapping.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Stream;

@ApplicationScoped
public interface TripRepository extends Repository<Trip, String> {

    Stream<Trip> findAll();
}
