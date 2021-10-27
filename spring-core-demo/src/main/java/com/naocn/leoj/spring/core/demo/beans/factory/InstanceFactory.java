package com.naocn.leoj.spring.core.demo.beans.factory;

import com.naocn.leoj.spring.core.demo.beans.AccountService;
import com.naocn.leoj.spring.core.demo.beans.Leaf;
import com.naocn.leoj.spring.core.demo.beans.Tree3;

public class InstanceFactory {
    private static AccountService accountService = new AccountService();

    public AccountService getAccountService() {
        return accountService;
    }

    public Tree3 getInstance(Leaf leaf) {
        return new Tree3(leaf);
    }
}
