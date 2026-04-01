package com.manu.account.enums;

import lombok.Getter;

@Getter
public enum ACCOUNT_TYPE {
    SAVINGS("Savings"),
    CURRENT("Current");

    private final String name;
    ACCOUNT_TYPE(String name) {
        this.name = name;
    }

}
