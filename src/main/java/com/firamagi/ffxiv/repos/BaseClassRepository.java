package com.firamagi.ffxiv.repos;

import com.firamagi.ffxiv.domains.BaseClass;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jesse on 1/15/14.
 */

public interface BaseClassRepository extends GraphRepository<BaseClass> {
    BaseClass findOne(Long id);

    BaseClass findByName(String name);
}
