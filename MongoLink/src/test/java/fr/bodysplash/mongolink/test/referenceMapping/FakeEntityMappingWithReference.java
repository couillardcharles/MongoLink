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

package fr.bodysplash.mongolink.test.referenceMapping;

import fr.bodysplash.mongolink.domain.mapper.EntityMap;
import fr.bodysplash.mongolink.domain.mapper.EntityMapper;
import fr.bodysplash.mongolink.test.entity.FakeEntity;

public class FakeEntityMappingWithReference extends EntityMap<FakeEntity> {

    public FakeEntityMappingWithReference() {
        super(FakeEntity.class);
        innerMapper = new EntityMapper<FakeEntity>(FakeEntity.class);
    }

    public FakeEntityMappingWithReference(EntityMapper<FakeEntity> mapper) {
        super(FakeEntity.class);
        this.innerMapper = mapper;
    }

    @Override
    protected void map() {
        References(element().getOtherEntity());
    }

    @Override
    protected EntityMapper<FakeEntity> getMapper() {
        return innerMapper;
    }

    private EntityMapper<FakeEntity> innerMapper;
}
