package repos;

import domains.CraftingClass;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by jesse on 4/24/14.
 */
public interface CraftingClassRepository extends GraphRepository<CraftingClass> {
}
