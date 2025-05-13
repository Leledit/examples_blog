package com.messaging.kafka;

import com.messaging.model.Pedido;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducerKafka {
    private final KafkaTemplate<String, Pedido> kafkaTemplate;

    public PedidoProducerKafka(KafkaTemplate<String, Pedido> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarPedido(Pedido pedido) {
        kafkaTemplate.send(KafkaConfig.TOPICO_PEDIDOS, pedido);
        System.out.println("✅ Pedido enviado via Kafka: " + pedido);
    }
}
