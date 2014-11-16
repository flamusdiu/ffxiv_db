package com.firamagi.ffxiv.domains;

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

    @RelatedTo(type = "WEARS", direction = Direction.BOTH)
    private Set<BaseClass> classes;

    @RelatedToVia(type="WEARS", direction = Direction.BOTH)
    private Set<WearableItem> wearableItems;

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

    public BaseClass addClass(BaseClass baseClass) {
        classes.add(baseClass);

        return baseClass;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", itemLevel=" + itemLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!classes.equals(item.classes)) return false;
        if (!itemLevel.equals(item.itemLevel)) return false;
        if (!name.equals(item.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + itemLevel.hashCode();
        result = 31 * result + classes.hashCode();
        return result;
    }
}
