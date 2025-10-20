package com.codegym.generic.generic_subtype_class;

class BoundType<T extends A> {

    private T objRef;

    public BoundType(T obj) {
        this.objRef = obj;
    }

    public void doRunTest() {
        this.objRef.displayClass();
    }
}
