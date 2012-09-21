/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/dao/DaoImplIT.e.vm.java
 */
package com.jaxio.dao;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaxio.domain.Role;
import com.jaxio.repository.RoleGenerator;
import com.jaxio.dao.RoleDao;

/**
 * Integration test on RoleDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class RoleDaoImplIT {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RoleDaoImplIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private RoleDao roleDao;

    @Inject
    private RoleGenerator roleGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        Role role = roleGenerator.getRole();

        // add it to a Set before saving (force equals/hashcode)
        Set<Role> set = newHashSet(role, role);
        assertThat(set).hasSize(1);

        roleDao.save(role);
        entityManager.flush();

        // reload it from cache and check equality
        Role model = new Role();
        model.setId(role.getId());
        assertThat(role).isEqualTo(roleDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // since you use a business key, equality must be preserved.
        assertThat(role).isEqualTo(roleDao.get(model));
    }
}