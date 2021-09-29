package com.naocn.leoj.spring.core.demo.beans;

public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService(){}

    public static ClientService getInstance() {
        return clientService;
    }

    public void sayHello() {
        System.out.println("ClientService: hello world!");
    }
}
