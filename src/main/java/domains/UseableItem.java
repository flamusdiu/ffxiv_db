package domains;

import org.springframework.data.neo4j.annotation.RelationshipEntity;

import java.lang.reflect.Type;

/**
 * Created by jesse on 4/29/2014.
 */
@RelationshipEntity(type = "USES")
public class UseableItem {

    private Item item;
    private Integer levelRequirement;

    public UseableItem() {}

    public UseableItem (Item item, Integer levelRequirement) {
        this.item = item;
        this.levelRequirement = levelRequirement;
    }
}
