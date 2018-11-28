package cn.itcast.ssm.base.dao.imp;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * created  by  yuwen on 2018/4/8
 */
@Configuration
public class MongoConfig {

    @Autowired
    private MongoClient mongoClient;

    //(配置文件前缀为spring.param.mongodb的属性)
    @Autowired
    private MongoProperties properties;

    @Bean(name = "dsForRW")
    public Datastore datastore() {
        Morphia morphia = new Morphia();

        Datastore datastore = morphia.createDatastore(mongoClient, properties.getDatabase());
        datastore.ensureIndexes();
        datastore.ensureCaps();
        return datastore;
    }

   /* @Value("${mongo.drugorg.uri}")
    private String mongoUri;

    @Value("${mongo.drugorg.dbName}")
    private String mongoDbName;
    @Autowired
    private MongoClient mongoClient;

    //(配置文件前缀为spring.param.mongodb的属性)
    @Autowired
    private MongoProperties properties;
    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(new MongoClientURI(this.getMongoUri()));
    }

    public String getMongoUri() {
        return mongoUri;
    }
    @Bean(name = "dsForRW")
    public Datastore datastore() {
        Morphia morphia = new Morphia();
        Datastore datastore = null;
        try {
            datastore = morphia.createDatastore(mongoClient(),  this.getMongoDbName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        datastore.ensureIndexes();
        datastore.ensureCaps();
        return datastore;
    }
    public String getMongoDbName() {
        return mongoDbName;
    }*/
}
