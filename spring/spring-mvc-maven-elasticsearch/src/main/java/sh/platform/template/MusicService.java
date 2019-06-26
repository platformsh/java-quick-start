package sh.platform.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;
import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static sh.platform.template.ElasticsearchConfig.INDEX;
import static sh.platform.template.ElasticsearchConfig.TYPE;

@Repository
public class MusicService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestHighLevelClient client;

    public List<Music> findAll(String search) throws IOException {


        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        if (!StringUtils.isEmpty(search)) {
            final BoolQueryBuilder queryBuilder = boolQuery().should(termQuery("lyrics", search))
                    .should(termQuery("name", search))
                    .should(termQuery("singer", search));
            sourceBuilder.query(queryBuilder);
        }

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(INDEX);
        searchRequest.source(sourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return stream(response.getHits().spliterator(), false)
                .map(SearchHit::getSourceAsMap)
                .map(s -> objectMapper.convertValue(s, Music.class))
                .collect(Collectors.toList());
    }

    public List<Music> findAll() throws IOException {
        return findAll(null);
    }

    public Optional<Music> findById(String id) throws IOException {

        GetRequest request = new GetRequest(INDEX, TYPE, id);
        final GetResponse response = client.get(request, RequestOptions.DEFAULT);
        final Map<String, Object> source = response.getSource();
        if (source.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(objectMapper.convertValue(source, Music.class));
        }
    }

    public void save(Music music) throws IOException {

        if (StringUtils.isEmpty(music.getId())) {
            music.setId(UUID.randomUUID().toString());
        }
        Map<String, Object> jsonMap = objectMapper.convertValue(music, Map.class);
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE)
                .id(music.getId()).source(jsonMap);
        client.index(indexRequest, RequestOptions.DEFAULT);
    }

    public void delete(Music music) throws IOException {
        client.delete(new DeleteRequest(INDEX, TYPE, music.getId()), RequestOptions.DEFAULT);
    }
}
