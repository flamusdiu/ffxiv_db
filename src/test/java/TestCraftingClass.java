import domains.CraftingClass;
import domains.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import repos.CraftingClassRepository;
import repos.ItemRepository;

import static org.junit.Assert.assertEquals;

/**
 * Created by jesse on 4/24/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfigTest.class})
public class TestCraftingClass {
    @Autowired
    private CraftingClassRepository craftingClassRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    @Test
    public void shouldCreateCraftingClass () {
        CraftingClass craftingClass = new CraftingClass("Tailor").persist();

        CraftingClass craftingClass1 = craftingClassRepository.findOne(craftingClass.getNodeId());

        assertEquals(craftingClass,craftingClass1);
    }

    @Transactional
    @Test
    public void shouldCreateItem() {
        CraftingClass craftingClass = new CraftingClass("Tailor").persist();

        Item item = new Item ("Shirt", 20).persist();

        craftingClass.creates(item,10).persist();
    }
}
