package com.codegym.generic.generic_subtype_class;


public class Main {

    public static void main(String args[]) {
        // Creating object of sub class C and
        // passing it to Bound as a type parameter.
        BoundType<C> bec = new BoundType<C>(new C());
        bec.doRunTest();

        // Creating object of sub class B and
        // passing it to Bound as a type parameter.
        BoundType<B> beb = new BoundType<B>(new B());
        beb.doRunTest();

        // similarly passing super class A
        BoundType<A> bea = new BoundType<A>(new A());
        bea.doRunTest();

    }
}
