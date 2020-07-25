package com.upgrad.hirewheels.constants;

public enum StatusEnum {
    PENDING(301),
    APPROVED(302),
    REJECTED(303);

    private final int value;

    StatusEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
