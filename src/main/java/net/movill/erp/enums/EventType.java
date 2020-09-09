package net.movill.erp.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EventType {
    CAR, RESIDENT, BILL;

    @JsonCreator
    public static EventType fromValue(String value) {
        switch (value.toUpperCase()) {
            case "CAR":
                return CAR;
            case "RESIDENT":
                return RESIDENT;
            case "BILL":
                return BILL;
            default:
                return null;
        }
    }

}
