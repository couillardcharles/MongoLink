/*
 * MongoLink, Object Document Mapper for Java and MongoDB
 *
 * Copyright (c) 2012, Arpinum or third-party contributors as
 * indicated by the @author tags
 *
 * MongoLink is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MongoLink is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License
 * along with MongoLink.  If not, see <http://www.gnu.org/licenses/>. 
 *
 */

package fr.bodysplash.mongolink.test.simpleMapping;

import fr.bodysplash.mongolink.domain.mapper.EntityMap;
import fr.bodysplash.mongolink.test.entity.FakeEntity;

public class FakeEntityMapping extends EntityMap<FakeEntity> {

    public FakeEntityMapping() {
        super(FakeEntity.class);
    }

    @Override
    public void map() {
        id(element().getId());
        property(element().getValue());
        collection(element().getComments());
        property(element().getComment());
    }
}
