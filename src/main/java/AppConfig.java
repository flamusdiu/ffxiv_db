import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.aspects.config.Neo4jAspectConfiguration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "repos")
public class AppConfig extends Neo4jAspectConfiguration {

    private static final String DB_PATH = "/home/jesse/IdeaProjects/ffxiv_db/db";

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        // if you want to use Neo4j as a REST service
        //return new SpringRestGraphDatabase("http://localhost:7474/db/data/");
        // Use Neo4j as Odin intended (as an embedded service)
        GraphDatabaseService service = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
        return service;
    }

    AppConfig () {
        setBasePackage("domains");
    }
}