package com.yjy.auto;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import yjy.spring.boot.samples.autoconfigure.formatter.Formatter;

import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
public class FormatterBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //待格式化对象
        Map<String,Object> data = new HashMap<>();
        data.put("name", "yjy");
        //获取 Formatter， 来自 FormatterAutoConfiguration
        Formatter formatter = context.getBean(Formatter.class);
        System.out.printf("formatter.format(date:%s) \n",formatter.format(data));

        context.close();
    }
}
