package yjy.spring.boot.samples.autoconfigure.formatter.impl;

import yjy.spring.boot.samples.autoconfigure.formatter.Formatter;

public class DefaultFormatter implements Formatter {

    @Override
    public String format(Object object) {
        return String.valueOf(object);
    }

}
