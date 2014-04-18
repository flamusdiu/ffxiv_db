import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.neo4j.aspects.config.Neo4jAspectConfiguration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by jesse on 1/27/14.
 */

@Configuration
@ComponentScan(basePackages = "domains")
@EnableNeo4jRepositories(basePackages = "repos")
//@EnableSpringConfigured
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ )
public class AppConfigTest extends Neo4jAspectConfiguration {

    public AppConfigTest () {
        setBasePackage("domains");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new TestGraphDatabaseFactory().newImpermanentDatabase();
    }

}
