package com.naocn.leoj.spring.core.demo.factory;

import com.naocn.leoj.spring.core.demo.beans.AccountService;
import com.naocn.leoj.spring.core.demo.beans.ClientService;
import com.naocn.leoj.spring.core.demo.beans.Leaf;

public class InstanceFactory {
    private static AccountService accountService = new AccountService();

    public AccountService getAccountService() {
        return accountService;
    }
}
