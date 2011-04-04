package fr.bodysplash.mongolink.mapper;

import org.apache.log4j.Logger;

public abstract class ClassMap<T> extends AbstractMap<T> {

    protected ClassMap(Class<T> type) {
        super(type);
    }

    @Override
    protected Mapper<T> createMapper(Class<T> type) {
        return new EntityMapper(type);
    }

    @Override
    protected EntityMapper<T> getMapper() {
        return (EntityMapper<T>) super.getMapper();
    }

    protected IdMapper id(Object value) {
        LOGGER.debug("Mapping id " + getLastMethod().shortName());
        IdMapper id = new IdMapper(getLastMethod(), IdGeneration.Auto);
        getMapper().setId(id);
        return id;
    }

    private static final Logger LOGGER = Logger.getLogger(ClassMap.class);

}
