package com.messaging.rabbitmq;

import com.messaging.model.Pedido;
import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Data
public class PedidoProducerRabbit {

    private final AmqpTemplate rabbitTemplate;

    public void enviarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOME_FILA, pedido);
        System.out.println("✅ Pedido enviado via RabbitMQ: " + pedido);
    }
}