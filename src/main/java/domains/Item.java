package domains;

import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.Collection;
import java.util.Set;

/**
 * Created by jesse on 4/14/14.
 */
@NodeEntity
@TypeAlias(value = "Item")
public class Item extends AbstractEntity {

    private String name;

    private String description;

    private Integer itemLevel;

    @RelatedTo(type = "WEARS", direction = Direction.INCOMING)
    private Set<BaseClass> classes;

    @RelatedToVia(type="WEARS", direction = Direction.INCOMING)
    private Iterable<WearableItem> wearableItems;

    public Item () {}

    public Item (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item (String name, Integer itemLevel) {
        this.name = name;
        this.itemLevel = itemLevel;
    }

    public Collection<BaseClass> getClasses() {
        return IteratorUtil.asCollection(this.classes);
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + getNodeId() + '\'' +
                ", name='" + name + '\'' +
                ", itemLevel=" + itemLevel +
                '}';
    }
}
