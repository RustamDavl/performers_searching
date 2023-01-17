package com.rustdv.webconstruction.mapping;

public interface Mapper<F, T>{

    T mapFrom(F from);

    default T update(F from, T to) {
        return to;
    }


}
