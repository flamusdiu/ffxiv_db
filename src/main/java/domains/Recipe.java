package domains;

import org.neo4j.graphdb.Direction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Collection;
import java.util.Set;

/**
 * Created by jesse on 4/14/14.
 */
@NodeEntity
@TypeAlias(value = "Recipe")
public class Recipe {

    @GraphId
    private  Long id;

    @Indexed
    private String name;

    private String description;

    private Integer recipeLevel;

    private Integer craftmanship;

    @RelatedTo(type="CREATES", direction = Direction.INCOMING, elementClass = BaseClass.class)
    private Set<BaseClass> classes;

    @RelatedTo(type="CREATES", elementClass = Item.class)
    private Set<Item> items;

    public Recipe() {}

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Recipe(String name, Integer recipeLevel) {
        this.name = name;
        this.recipeLevel = recipeLevel;
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
                ", recipeLevel=" + recipeLevel +
                '}';
    }
}
