package com.upgrad.hirewheels.constants;

public enum ActivityEnum {
    VEHICLE_REGISTER(201),
    CAR_OPT_IN(202),
    CAR_OPT_OUT(203);

    private final int value;

    ActivityEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
