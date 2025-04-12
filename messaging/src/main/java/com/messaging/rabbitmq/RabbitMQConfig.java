package com.messaging.rabbitmq;


import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String NOME_FILA = "fila.pedidos";

    @Bean
    public Queue filaPedidos() {
        return new Queue(NOME_FILA, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter(); // Converte objetos em JSON e vice-versa
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}