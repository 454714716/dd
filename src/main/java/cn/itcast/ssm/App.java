package cn.itcast.ssm;

import cn.itcast.ssm.Entity.CompanyApp;
import cn.itcast.ssm.service.imple.BaseRepositoryImpl;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 启动类
 * @author wangqiao
 * @date 2017年3月28日
 */
/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableScheduling
@EnableAsync
@EnableEurekaClient
@EnableRetry
@EnableMongoRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@ComponentScan("cn.itcast")*/
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableMongoRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@ImportResource(locations={"classpath:spring/applicationContext.xml"})
public class App implements EnvironmentAware/*, ApplicationContextAware*/ {
/*	@Value("${mongo.drugorg.uri}")
	private String mongoUri;

	@Value("${mongo.drugorg.dbName}")
	private String mongoDbName;*/
	public static void main(String[] args) throws IOException {
		SpringApplication app = new SpringApplication(App.class);
		app.setWebEnvironment(true);
		app.run(args);
	}

	@Override
	public void setEnvironment(Environment environment) {

	}
 /*   @Bean
    public Morphia morphia() {
        Morphia morphia = new Morphia();
//        morphiaMap(morphia);
        return morphia;
    }
    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(new MongoClientURI(this.getMongoUri()));
    }
    protected static final List<Class> mapClasses = new ArrayList<>();

    static {
        mapClasses.add(CompanyApp.class);
    }
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        context = ctx;
    }

    public String getMongoUri() {
        return mongoUri;
    }
    @PostConstruct
    public void reIndex() {
        String tag = "reIndex";

        Map<String, Object> handlerMap = context.getBeansWithAnnotation(Model.class);
        for (Map.Entry<String, Object> entry : handlerMap.entrySet()) {
            Class<?> clz = entry.getValue().getClass();
            if (clz.isAnnotationPresent(Model.class)) {
                Model annotation = clz.getAnnotation(Model.class);
                Class<?> entityClass = annotation.value();
                mapClasses.add(entityClass);
            }
        }

        Morphia morphia = (Morphia) context.getBean("morphia");
        for (Class clazz : mapClasses) {
            morphia.map(clazz);
        }

        Datastore datastore = (Datastore) context.getBean("dsForRW");
        datastore.ensureIndexes(true);
        datastore.ensureCaps();
    }

	@Bean(name = "dsForRW")
	public Datastore datastore(MongoClient mongoClient, Morphia morphia) {
		Datastore datastore = morphia.createDatastore(mongoClient, this.getMongoDbName());
//        datastore.ensureIndexes();
//        datastore.ensureCaps();
		return datastore;
	}
	public String getMongoDbName() {
		return mongoDbName;
	}*/
}
