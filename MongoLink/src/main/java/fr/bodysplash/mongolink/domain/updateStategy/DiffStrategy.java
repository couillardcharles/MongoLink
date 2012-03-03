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

package fr.bodysplash.mongolink.domain.updateStategy;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;

public class DiffStrategy extends UpdateStrategy {

    @Override
    public void update(DBObject initialValue, DBObject update, DBCollection collection) {
        final DBObject diff = new DbObjectDiff(initialValue).compareWith(update);
        if (!diff.keySet().isEmpty()) {
            final DBObject q = updateQuery(initialValue);
            LOGGER.debug("Updating query:" + q + " values: " + diff);
            collection.update(q, diff);
        }
    }

    private static Logger LOGGER = Logger.getLogger(DiffStrategy.class);
}