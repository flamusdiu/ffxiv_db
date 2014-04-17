package repos;

import domains.WearableItem;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jesse on 4/15/14.
 */
public interface WearableItemRepository extends GraphRepository<WearableItem>{
    WearableItem findOne(Long id);
}
