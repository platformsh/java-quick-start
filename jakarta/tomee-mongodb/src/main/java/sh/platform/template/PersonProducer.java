/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sh.platform.template;

import com.mongodb.MongoClient;
import jakarta.nosql.document.DocumentCollectionManager;
import org.jnosql.diana.mongodb.document.MongoDBDocumentCollectionManagerFactory;
import org.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;
import sh.platform.config.Config;
import sh.platform.config.MongoDB;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PersonProducer {

    @Produces
    @ApplicationScoped
    public DocumentCollectionManager getDocumentCollectionManager() {
        Config config = new Config();
        final MongoDB mongo = config.getCredential("mongodb", MongoDB::new);
        final MongoClient mongoClient = mongo.get();
        MongoDBDocumentConfiguration configuration = new MongoDBDocumentConfiguration();
        MongoDBDocumentCollectionManagerFactory factory = configuration.get(mongoClient);
        return factory.get(mongo.getDatabase());
    }

    public void close(@Disposes DocumentCollectionManager manager) {
        manager.close();
    }
}