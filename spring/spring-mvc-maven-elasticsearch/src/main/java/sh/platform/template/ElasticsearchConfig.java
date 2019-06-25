package sh.platform.template;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sh.platform.config.Config;
import sh.platform.config.Elasticsearch;

import java.io.IOException;

@Configuration
public class ElasticsearchConfig {

    static final String INDEX = "musics";
    static final String TYPE = "music";

    @Bean
    public RestHighLevelClient elasticsearchTemplate() throws IOException {
        Config config = new Config();
        final Elasticsearch credential = config.getCredential("elasticsearch", Elasticsearch::new);
        final RestHighLevelClient client = credential.get();
        CreateIndexRequest request = new CreateIndexRequest(INDEX);

        GetIndexRequest exist = new GetIndexRequest();
        exist.indices(INDEX);
        if (!client.indices().exists(exist, RequestOptions.DEFAULT)) {
            client.indices().create(request, RequestOptions.DEFAULT);
        }
        return client;
    }
}
