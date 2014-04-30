package domains;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.Set;

/**
 * Created by jesse on 4/29/2014.
 */
public abstract class AbstractBaseClass implements BaseClassInt{

    @Indexed(unique = true)
    private String name;
    private String description;

    @RelatedToVia(type = "USES",elementClass = UseableItem.class)
    private Set<UseableItem> usableItems;

    public AbstractBaseClass (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    };

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    };

    @Override
    public void setDescription( String description ) {
        this.description = description;
    };

    @Override
    public UseableItem uses (Item  item, Integer LevelRequirment) {
        UseableItem useableItem = new UseableItem(item,LevelRequirment);

        usableItems.add(useableItem);

        return useableItem;

    }

    @Override
    public Set<UseableItem> getUsableItems () {
        return usableItems;
    }

}
