package com.autoflex.tms.entities;

public enum Status {
    NEW, TODO, //manager
    IN_PROGRESS, DONE, CANCELED, //employee
    POSTPONED, ARCHIVED //manager
}