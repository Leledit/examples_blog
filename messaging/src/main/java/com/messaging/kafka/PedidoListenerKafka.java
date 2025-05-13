package com.messaging.kafka;

import com.messaging.model.Pedido;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListenerKafka {

    @KafkaListener(topics = KafkaConfig.TOPICO_PEDIDOS, groupId = "grupo-pedidos",
            containerFactory = "kafkaListenerContainerFactory")
    public void processarPedido(Pedido pedido) {
        System.out.println("📥 Pedido recebido via Kafka: " + pedido);
    }
}
