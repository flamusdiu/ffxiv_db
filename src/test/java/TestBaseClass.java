import domains.BaseClass;
import domains.Item;
import domains.WearableItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    @Test
    public void shouldCreateNode() {

        BaseClass testClass = baseClassRepository.save(new BaseClass("Archer"));
        BaseClass testClass1 = baseClassRepository.findOne(testClass.getNodeId());
        assertEquals(testClass1.getName(), "Archer");
    }

    @Transactional
    @Test
    public void shouldAssignWearable() {

        BaseClass testClass = new BaseClass("Archer").persist();

        Item item = new Item("Test item", 20).persist();

        WearableItem wearableItem = testClass.wears(item, 20).persist();

        Item item1 = itemRepository.findById(item.getNodeId());
        assertNotNull("did not find item", item1);
        assertEquals(item, item1);

        Iterator<BaseClass> classes = item1.getClasses().iterator();

        System.out.println(item.getClasses().size());
        while(classes.hasNext()) {
            System.out.println(classes.next().getName());
        }
    }
}