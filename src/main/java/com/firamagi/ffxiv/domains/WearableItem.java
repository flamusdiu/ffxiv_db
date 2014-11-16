package com.firamagi.ffxiv.domains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by jesse on 4/14/14.
 */

@RelationshipEntity(type = "WEARS")
public class WearableItem extends AbstractEntity {
    private static final Logger logger = LoggerFactory.getLogger(WearableItem.class);

    @StartNode private Item item;
    @EndNode private BaseClass wearableClass;

    private Integer level;

    public WearableItem() { }

    public WearableItem(BaseClass wearableClass, Item item, Integer level) {
        logger.info("Creating new Wearable Item: " + wearableClass.getName() + ":" + item.getName());
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
