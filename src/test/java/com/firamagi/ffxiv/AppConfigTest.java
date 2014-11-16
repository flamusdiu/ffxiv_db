package com.firamagi.ffxiv;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.neo4j.aspects.config.Neo4jAspectConfiguration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableSpringConfigured
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.firamagi.ffxiv.domains")
@EnableNeo4jRepositories(basePackages = "com.firamagi.ffxiv.repos")
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class AppConfigTest extends Neo4jAspectConfiguration {
    public AppConfigTest() {
        setBasePackage("com.firamagi.ffxiv");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService(){
        return new TestGraphDatabaseFactory().newImpermanentDatabase();
    }
}