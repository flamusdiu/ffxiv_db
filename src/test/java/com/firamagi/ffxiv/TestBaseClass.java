package com.firamagi.ffxiv;

import com.firamagi.ffxiv.domains.BaseClass;
import com.firamagi.ffxiv.domains.Item;
import com.firamagi.ffxiv.domains.WearableItem;
import com.firamagi.ffxiv.repos.BaseClassRepository;
import com.firamagi.ffxiv.repos.ItemRepository;
import com.firamagi.ffxiv.repos.WearableItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.helpers.collection.IteratorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by jesse on 1/27/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfigTest.class})
public class TestBaseClass {

    private static Logger logger = LoggerFactory.getLogger(TestBaseClass.class);

    @Autowired
    private BaseClassRepository baseClassRepository;

    @Autowired
    private WearableItemRepository wearableItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Transactional
    public void shouldCreateNode() {

        BaseClass testClass1;
        BaseClass testClass;
        testClass = new BaseClass();
        testClass.setName("Archer");
        baseClassRepository.save(testClass);
        testClass1 = baseClassRepository.findOne(testClass.getId());

        assertEquals(testClass1.getName(), "Archer");
    }

    @Test
    @Transactional
    public void shouldAssignWearable() {

        BaseClass testClass = new BaseClass("Archer");

        Item item = new Item("Test item", 20);

        testClass = baseClassRepository.save(testClass);
        item = itemRepository.save(item);

        WearableItem wearableItem = testClass.wears(item, 20);
        logger.info(wearableItem.toString());
        wearableItemRepository.save(wearableItem);

        assertNotNull(item.getName());
        assertNotNull(itemRepository);

        assertEquals(1, IteratorUtil.asCollection(wearableItemRepository.findAll().iterator()).size());

        assertNotNull(wearableItemRepository.findOne(wearableItem.getId()));

    }
}