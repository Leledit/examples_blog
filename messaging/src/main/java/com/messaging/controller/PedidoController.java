package com.messaging.controller;

import com.messaging.kafka.PedidoProducerKafka;
import com.messaging.model.Pedido;
import com.messaging.rabbitmq.PedidoProducerRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/jms")
    public ResponseEntity<String> enviarPedidoJms(@RequestBody Pedido pedido) {
        jmsTemplate.convertAndSend("fila.pedidos", pedido);
        return ResponseEntity.status(HttpStatus.OK).body("Pedido enviado via JMS!");
    }

    @Autowired
    private PedidoProducerRabbit pedidoProducer;
    @PostMapping("/rabbitmq")
    public ResponseEntity<String> enviarPedidoRabbitMq(@RequestBody Pedido pedido) {
        pedidoProducer.enviarPedido(pedido);
        return ResponseEntity.status(HttpStatus.OK).body("Pedido enviado via rabbitMq!");
    }

    @Autowired
    private PedidoProducerKafka pedidoProducerKafka;
    @PostMapping("/kafka")
    public ResponseEntity<String> enviarPedidoKafka(@RequestBody Pedido pedido) {
        pedidoProducerKafka.enviarPedido(pedido);
        return ResponseEntity.ok("Pedido enviado com sucesso via Kafka!");
    }
}
