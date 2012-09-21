/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.jaxio.domain;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

import com.jaxio.util.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Basic tests for Legacy
 */
@SuppressWarnings("unused")
public class LegacyTest {
    // test composite primary key

    @Test
    public void newInstanceHasNoPrimaryKey() {
        Legacy model = new Legacy();
        assertNotNull(model.getLegacyPk());
        assertFalse(model.isIdSet());
    }

    @Test
    public void setEmptyCompositePrimaryKey() {
        Legacy model = new Legacy();
        LegacyPk pk = new LegacyPk();
        model.setLegacyPk(pk);
        assertFalse(model.isIdSet());
        assertSame(pk, model.getLegacyPk());
    }

    @Test
    public void setValidCompositePrimaryKey() {
        Legacy model = new Legacy();
        LegacyPk pk = new LegacyPk();
        pk.setCode(ValueGenerator.getUniqueString(8));
        pk.setDept(ValueGenerator.getUniqueInteger());
        pk.setName(ValueGenerator.getUniqueString(16));
        model.setLegacyPk(pk);

        assertTrue(model.isIdSet());
        assertSame(pk, model.getLegacyPk());
    }

    // test columns methods

    //-------------------------------------------------------------
    // Composite Pk getter & setter
    //-------------------------------------------------------------

    @Test
    public void compositePrimaryKey_setLegacyPk() {
        Legacy model = new Legacy();
        assertNotNull(model.getLegacyPk());

        assertNull(model.getCode());
        assertNull(model.getDept());
        assertNull(model.getName());

        LegacyPk pk = new LegacyPk();

        String code = ValueGenerator.getUniqueString(8);
        pk.setCode(code);
        Integer dept = ValueGenerator.getUniqueInteger();
        pk.setDept(dept);
        String name = ValueGenerator.getUniqueString(16);
        pk.setName(name);

        model.setLegacyPk(pk);

        assertEquals(code, model.getCode());
        assertEquals(dept, model.getDept());
        assertEquals(name, model.getName());
    }

    @Test
    public void toStringNotNull() {
        Legacy model = new Legacy();
        assertNotNull(model.toString());
    }

    @Test
    public void equalsUsingPk() {
        Legacy model1 = new Legacy();
        Legacy model2 = new Legacy();

        String name = ValueGenerator.getUniqueString(16);
        model1.setName(name);
        model2.setName(name);

        String code = ValueGenerator.getUniqueString(8);
        model1.setCode(code);
        model2.setCode(code);

        Integer dept = ValueGenerator.getUniqueInteger();
        model1.setDept(dept);
        model2.setDept(dept);

        model1.setExtraInfo("a");
        model2.setExtraInfo("a");
        assertTrue(model1.isIdSet());
        assertTrue(model2.isIdSet());
        assertTrue(model1.hashCode() == model2.hashCode());
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
    }
}