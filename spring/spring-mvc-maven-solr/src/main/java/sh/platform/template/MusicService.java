package sh.platform.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Repository
public class MusicService {

    @Autowired
    private MusicRepository repository;

    public List<Music> findAll(String search) {

        if (repository.count() == 0) {
            return Collections.emptyList();
        }

        if (StringUtils.isEmpty(search)) {
            return stream(repository.findAll().spliterator(), false)
                    .collect(toList());
        }
        return repository.search(search);
    }

    public List<Music> findAll() {
        return findAll(null);
    }

    public Optional<Music> findById(String id) {
        return repository.findById(id);
    }

    @Transactional
    public void save(Music music) {
        if (StringUtils.isEmpty(music.getId())) {
            music.setId(UUID.randomUUID().toString());
        }
        repository.save(music);
    }


    @Transactional
    public void delete(Music music) {
        repository.delete(music);
    }
}
