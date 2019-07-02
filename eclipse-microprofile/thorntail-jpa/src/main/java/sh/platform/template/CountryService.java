package sh.platform.template;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CountryService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Country insert(Country country) {
        entityManager.persist(country);
        return country;
    }

    @Transactional
    public void update(Country country) {
        entityManager.persist(country);
    }

    @Transactional
    public void delete(Integer id) {
        find(id).ifPresent(c -> entityManager.remove(c));
    }


    public Optional<Country> find(Integer id) {
        return Optional.ofNullable(entityManager.find(Country.class, id));
    }

    public List<Country> findAll() {
        String query = "select c from Country c";
        return entityManager.createQuery(query).getResultList();
    }


}
