package domains;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.Set;

/**
 * Created by jesse on 4/12/2014.
 */

@NodeEntity
@TypeAlias(value = "CraftingClass")
public class CraftingClass extends BaseClass{

    @RelatedToVia(type = "CRAFTED_BY")
    Set<CraftedItem> craftedItems;

    public CraftedItem creates(Item item, Integer skillLevel) {
        final CraftedItem craftedItem = new CraftedItem(this, item, skillLevel);

        craftedItems.add(craftedItem);

        return craftedItem;
    }

}
