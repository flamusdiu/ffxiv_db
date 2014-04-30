package domains;

import java.util.Set;

/**
 * Created by jesse on 4/29/2014.
 */
public interface BaseClassInt {

    public String getName();
    public String getDescription();

    public void setName( String name);
    public void setDescription(String description);

    public int hashCode();
    public String toString();
    public boolean equals();

    public  UseableItem uses(Item item, Integer LevelRequirment);

    public  Set<UseableItem> getUsableItems();
}
