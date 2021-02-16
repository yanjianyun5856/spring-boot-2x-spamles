package com.yjy.auto;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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
        Map<String,Formatter> beans = context.getBeansOfType(Formatter.class);
        if (beans.isEmpty()){
            throw new NoSuchBeanDefinitionException(Formatter.class);
        }
        beans.forEach((beanName,formatter) -> {
            System.out.printf("[ Bean name : %s ] %s.formatter(date):%s \n" ,beanName,
                    formatter.getClass().getSimpleName(),formatter.format(data));
        });

        context.close();
    }
}
