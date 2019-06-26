package sh.platform.template;


import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface MusicRepository extends SolrCrudRepository<Music, String> {

    @Query("lyrics:*?0* OR name:*?0* OR singer:*?0*")
    List<Music> search(String searchTerm);
}
