import domains.BaseClass;
import domains.Item;
import domains.WearableItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repos.BaseClassRepository;
import repos.ItemRepository;
import repos.WearableItemRepository;

import java.util.Iterator;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by jesse on 1/27/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfigTest.class})
public class TestBaseClass {

    @Autowired
    private BaseClassRepository baseClassRepository;

    @Autowired
    private WearableItemRepository wearableItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void shouldCreateNode() {

        BaseClass testClass = new BaseClass();
         testClass.setName("Archer");

        BaseClass testClass1 = baseClassRepository.findOne(testClass.getId());
        assertEquals(testClass1.getName(), "Archer");
    }

    @Test
    public void shouldAssignWearable() {

        BaseClass testClass = new BaseClass("Archer").persist();

        Item item = new Item("Test item", 20).persist();

        testClass = baseClassRepository.save(testClass);
        item = itemRepository.save(item);

        WearableItem wearableItem = testClass.wears(item, 20);
        wearableItemRepository.save(wearableItem);

        Item item1 = itemRepository.findByName(item.getName());
        assertEquals(item, item1);
        assertNotNull("did not find item", item1);

        Iterator<BaseClass> classes = item1.getClasses().iterator();

        System.out.println(item.getClasses().size());
        while(classes.hasNext()) {
            System.out.println(classes.next().getName());
        }
    }
}