package repos;

import domains.CraftedItem;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jesse on 4/15/14.
 */
public interface CraftedItemRepository extends GraphRepository<CraftedItem>{
    CraftedItem findOne (Long id);
}
