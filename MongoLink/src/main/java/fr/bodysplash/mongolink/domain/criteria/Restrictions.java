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

package fr.bodysplash.mongolink.domain.criteria;

public class Restrictions {

    public static Restriction equals(String field, Object value) {
        return factory.getEquals(field, value);
    }

    public static Restriction between(String field, Object start, Object end) {
        return factory.getBetween(field, start, end);
    }

    public static Restriction notEquals(String field, Object value) {
        return factory.getNotEquals(field, value);
    }

    public static void setFactory(RestrictionFactory factory) {
        Restrictions.factory = factory;
    }

    private static RestrictionFactory factory = new RestrictionFactory();

}
