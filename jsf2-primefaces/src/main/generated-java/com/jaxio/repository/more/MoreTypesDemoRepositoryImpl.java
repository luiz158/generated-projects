/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/RepositoryImpl.e.vm.java
 */
package com.jaxio.repository.more;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.dao.support.GenericDao;
import com.jaxio.repository.support.RepositoryImpl;
import com.jaxio.domain.more.MoreTypesDemo;
import com.jaxio.dao.more.MoreTypesDemoDao;

/**
 * Default implementation of the {@link MoreTypesDemoRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see MoreTypesDemoRepository
 */
@Named("moreTypesDemoRepository")
@Singleton
public class MoreTypesDemoRepositoryImpl extends RepositoryImpl<MoreTypesDemo, Integer> implements MoreTypesDemoRepository {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(MoreTypesDemoRepositoryImpl.class);

    protected MoreTypesDemoDao moreTypesDemoDao;

    @Inject
    public void setMoreTypesDemoDao(MoreTypesDemoDao moreTypesDemoDao) {
        this.moreTypesDemoDao = moreTypesDemoDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<MoreTypesDemo, Integer> getDao() {
        return moreTypesDemoDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoreTypesDemo getNew() {
        return new MoreTypesDemo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MoreTypesDemo getNewWithDefaults() {
        MoreTypesDemo result = getNew();
        result.initDefaultValues();
        return result;
    }

}