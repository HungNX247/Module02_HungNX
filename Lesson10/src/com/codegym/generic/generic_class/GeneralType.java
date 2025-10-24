package com.codegym.generic.generic_class;

public class GeneralType<T> {

    T property;

    GeneralType(T property) {
        this.property = property;
    }

    public T getProperty() {
        return this.property;
    }
}
