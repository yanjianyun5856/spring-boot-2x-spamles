package yjy.spring.boot.samples.autoconfigure.formatter.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import yjy.spring.boot.samples.autoconfigure.formatter.Formatter;

public class JsonFormatter implements Formatter {

    private final ObjectMapper objectMapper;

    public JsonFormatter() {
        this.objectMapper = new ObjectMapper();
    }

    public JsonFormatter(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public String format(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            //解析失败返回非法参数异常
            throw new IllegalArgumentException(e);
        }
    }
}
