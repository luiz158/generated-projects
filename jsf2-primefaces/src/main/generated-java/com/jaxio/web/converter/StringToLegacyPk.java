/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/converter/stringtopk.cpk.vm.java
 */
package com.jaxio.web.converter;

import org.springframework.binding.convert.converters.StringToObject;

import com.jaxio.domain.LegacyPk;

public class StringToLegacyPk extends StringToObject {

    public StringToLegacyPk() {
        super(LegacyPk.class);
    }

    @Override
    protected Object toObject(String string, @SuppressWarnings("rawtypes") Class targetClass) throws Exception {
        return LegacyPk.fromString(string);
    }

    @Override
    protected String toString(Object object) throws Exception {
        LegacyPk pk = (LegacyPk) object;
        return pk.toString();
    }
}
