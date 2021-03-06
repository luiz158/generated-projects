/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/converter/EntityConverter.e.vm.java
 */
package com.jaxio.web.converter.domain;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.jaxio.domain.Account;
import com.jaxio.repository.AccountRepository;
import com.jaxio.web.converter.GenericJsfConverter;

/**
 * Responsible for creating Account JSF converters.
 * Each converter provides a 'print' method to convert an entity instance to a friendly string representation (readable by humans...).
 */
@Component
public class AccountConverter extends GenericJsfConverter<Account, String> {
    @Inject
    public AccountConverter(AccountRepository accountRepository) {
        super(accountRepository, String.class);
    }

    @Override
    public String print(Account account) {
        return account == null ? "" : "" + account.getUsername();
    }
}