package com.messaging.rabbitmq;

import com.messaging.model.Pedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListenerRabbit {

    @RabbitListener(queues = RabbitMQConfig.NOME_FILA)
    public void processarPedido(Pedido pedido) {
        System.out.println("📥 Pedido recebido via RabbitMQ: " + pedido);
    }
}