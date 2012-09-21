/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ServiceImplTest.e.vm.java
 */
package com.jaxio.repository;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

import com.jaxio.domain.Legacy;
import com.jaxio.repository.LegacyRepositoryImpl;
import com.jaxio.dao.LegacyDao;
import com.jaxio.dao.support.SearchParameters;

/**
 * Unit test on LegacyRepositoryImpl
 */
public class LegacyRepositoryImplTest {

    private LegacyRepositoryImpl legacyRepositoryImpl;
    private LegacyDao legacyDao;

    @Before
    public void setUp() {
        // called before each test.
        legacyRepositoryImpl = new LegacyRepositoryImpl();
        legacyDao = mock(LegacyDao.class);
        legacyRepositoryImpl.setLegacyDao(legacyDao);
    }

    @Test
    public void testFindUniqueOrNoneCaseNone() {
        Legacy none = null;

        when(legacyDao.findUniqueOrNone(any(Legacy.class), any(SearchParameters.class))).thenReturn(none);

        Legacy result = legacyRepositoryImpl.findUniqueOrNone(new Legacy());

        assertThat(result).isNull();
        verify(legacyDao, times(1)).findUniqueOrNone(any(Legacy.class), any(SearchParameters.class));
    }

    @Test
    public void testFindUniqueOrNoneCaseUnique() {
        Legacy unique = new Legacy();

        when(legacyDao.findUniqueOrNone(any(Legacy.class), any(SearchParameters.class))).thenReturn(unique);

        Legacy result = legacyRepositoryImpl.findUniqueOrNone(new Legacy());

        assertThat(result).isNotNull();
        verify(legacyDao, times(1)).findUniqueOrNone(any(Legacy.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueOrNoneCaseMultiple() {
        when(legacyDao.findUniqueOrNone(any(Legacy.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        legacyRepositoryImpl.findUniqueOrNone(new Legacy());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void testFindUniqueCaseNone() {
        when(legacyDao.findUnique(any(Legacy.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        legacyRepositoryImpl.findUnique(new Legacy());
    }

    @Test
    public void testFindUniqueCaseUnique() {
        Legacy unique = new Legacy();

        when(legacyDao.findUnique(any(Legacy.class), any(SearchParameters.class))).thenReturn(unique);

        Legacy result = legacyRepositoryImpl.findUnique(new Legacy());

        assertThat(result).isNotNull();
        verify(legacyDao, times(1)).findUnique(any(Legacy.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueCaseMultiple() {
        when(legacyDao.findUnique(any(Legacy.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        legacyRepositoryImpl.findUnique(new Legacy());
    }
}