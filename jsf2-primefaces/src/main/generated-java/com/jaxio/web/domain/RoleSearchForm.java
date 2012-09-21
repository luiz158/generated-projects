/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/SearchForm.e.vm.java
 */
package com.jaxio.web.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jaxio.domain.Role;
import com.jaxio.web.domain.support.SearchFormBase;

/**
 * Simple parameters holder for role search.
 */
@Component
@Scope("session")
public class RoleSearchForm extends SearchFormBase {
    private static final long serialVersionUID = 1L;

    private Role role = new Role();

    public Role getRole() {
        return role;
    }
}