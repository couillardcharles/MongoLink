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

package fr.bodysplash.mongolink;

import fr.bodysplash.mongolink.domain.mapper.ClassMapper;
import fr.bodysplash.mongolink.domain.mapper.ContextBuilder;
import fr.bodysplash.mongolink.domain.mapper.MapperContext;
import fr.bodysplash.mongolink.test.entity.Comment;
import fr.bodysplash.mongolink.test.entity.FakeChildEntity;
import fr.bodysplash.mongolink.test.entity.FakeEntity;
import fr.bodysplash.mongolink.test.entity.FakeEntityWithNaturalId;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TestsContextBuilder {

    @Test
    public void canLoadMappingFromPackage() {
        ContextBuilder builder = new ContextBuilder("fr.bodysplash.mongolink.test.simpleMapping");

        MapperContext context = builder.createContext();

        assertThat(context.mapperFor(FakeEntity.class), notNullValue());
        assertThat(context.mapperFor(FakeEntityWithNaturalId.class), notNullValue());
        assertThat(context.mapperFor(Comment.class), notNullValue());
    }

    @Test
    public void dontLoadSubclassMap() {
        ContextBuilder builder = new ContextBuilder("fr.bodysplash.mongolink.test.inheritanceMapping");

        MapperContext context = builder.createContext();

        ClassMapper mapper = context.mapperFor(FakeChildEntity.class);
        assertThat(mapper, is((ClassMapper) context.mapperFor(FakeEntity.class)));
    }
}
