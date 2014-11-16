package com.firamagi.ffxiv.repos;

import com.firamagi.ffxiv.domains.Item;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jesse on 4/14/14.
 */
public interface ItemRepository extends GraphRepository<Item>{

    Item findByName (String name);
}
