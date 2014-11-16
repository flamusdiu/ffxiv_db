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

import org.springframework.data.neo4j.annotation.GraphId;

/**
 * Created by jesse on 1/18/14.
 */
public abstract class AbstractEntity {
    @GraphId
    public Long id;

    public AbstractEntity() {
    }

    public Long getId () {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
}
