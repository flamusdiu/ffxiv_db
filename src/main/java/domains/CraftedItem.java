package domains;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by jesse on 4/14/14.
 */

@RelationshipEntity(type = "CRAFTED_BY")
public class CraftedItem extends AbstractEntity {

    @StartNode
    private CraftingClass craftingClass;

    @EndNode
    private Item item;

    private Integer skillLevel;

    public CraftedItem() { }

    public CraftedItem(CraftingClass craftingClass, Item item, Integer skillLevel) {
        this.craftingClass = craftingClass;
        this.item = item;
        this.skillLevel = skillLevel;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public CraftingClass getCraftingClass() {
        return craftingClass;
    }

    public void setCraftingClass(CraftingClass craftingClass) {
        this.craftingClass = craftingClass;
    }

}
