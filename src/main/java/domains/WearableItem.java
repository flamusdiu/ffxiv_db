package domains;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by jesse on 4/14/14.
 */

@RelationshipEntity(type = "WEARS")
public class WearableItem extends AbstractEntity {

    @StartNode private Item item;
    @EndNode private BaseClass wearableClass;

    private Integer level;

    public WearableItem() { }

    public WearableItem(BaseClass wearableClass, Item item, Integer level) {
        this.wearableClass = wearableClass;
        this.item = item;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.level = skillLevel;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BaseClass getWearableClass() {
        return wearableClass;
    }

    public void setWearableClass(BaseClass wearableClass) {
        this.wearableClass = wearableClass;
    }


    @Override
    public String toString() {
        return "WearableItem{" +
                "wearableClass=" + wearableClass +
                ", item=" + item +
                ", level=" + level +
                '}';
    }
}
