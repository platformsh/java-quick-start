package sh.platform.demo.heroes;


import jakarta.nosql.mapping.Page;
import jakarta.nosql.mapping.Pagination;
import jakarta.nosql.mapping.Repository;

import java.util.stream.Stream;

public interface HeroRepository extends Repository<Hero, String> {

    Stream<Hero> findAll();

    Page<Hero> findAll(Pagination pagination);

    Stream<Hero> findByPowersIn(String powers);

    Stream<Hero> findByAgeGreaterThan(Integer age);

    Stream<Hero> findByAgeLessThan(Integer age);
}
