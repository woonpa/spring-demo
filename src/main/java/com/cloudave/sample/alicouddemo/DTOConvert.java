package com.cloudave.sample.alicouddemo;

public interface DTOConvert<S, T> {
    T convert(S s);
}
