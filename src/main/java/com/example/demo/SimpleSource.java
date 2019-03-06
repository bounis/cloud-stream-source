package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;


@EnableBinding(MySource.class)
public class SimpleSource {



    private SimpleDateFormat simpleDate =
            new SimpleDateFormat("HH:mm:ss");
    @Bean
    @InboundChannelAdapter("sourceChannel")
    public MessageSource<String> simpleText(){
        return () -> MessageBuilder
                .withPayload("Hello at " +
                        simpleDate.format(new Date()))
                .build();
    }
}
