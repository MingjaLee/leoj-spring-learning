package com.naocn.leoj.spring.core.demo.beans.factory;

import com.naocn.leoj.spring.core.demo.beans.Leaf;

public class StaticLeafFactory {
    public static Leaf getInstance() {
        return new Leaf();
    }
}
