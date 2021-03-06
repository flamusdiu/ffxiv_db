/*******************************************************************************
 * ffxiv_db residing in Finial Fanasty Item Database (unofficial)
 *     Copyright (C) 2014  Jesse Spangenberger <azulephoenix at gmail dot com>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/

package com.firamagi.ffxiv.domains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jesse on 1/13/14.
 */
@NodeEntity
@TypeAlias(value = "Class")
public class BaseClass extends AbstractEntity {

    private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);

    @Indexed(unique = true)
    private String name;

    private String description;

    @RelatedTo(type = "AdvancedClass", elementClass = BaseClass.class)
    Set<BaseClass> advanceClass;

    @RelatedToVia(type = "WEARS")
    @Fetch
    Set<WearableItem> wearableItems = new HashSet<>();

    public Collection<BaseClass> getAdvanceClass() {
        return advanceClass;
    }

    public void setAdvanceClass(Set<BaseClass> advanceClass) {
        this.advanceClass = advanceClass;
    }

    public BaseClass ( ) {}

    public BaseClass (String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public WearableItem wears (Item item, Integer wearableAtLevel) {

        final WearableItem wearableItem = new WearableItem(this,item,wearableAtLevel);
        wearableItems.add(wearableItem);

        return wearableItem;
    }

    public Collection<WearableItem> getWearableItems() {
        return this.wearableItems;
    }

    public void addAdvanceClass (BaseClass advanceClass) {
        this.advanceClass.add(advanceClass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseClass baseClass = (BaseClass) o;

        return name.equals(baseClass.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
