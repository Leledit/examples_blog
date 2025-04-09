package com.messaging.controller;

import com.messaging.model.Pedido;
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

    @PostMapping
    public ResponseEntity<String> enviarPedido(@RequestBody Pedido pedido) {
        jmsTemplate.convertAndSend("fila.pedidos", pedido);
        return ResponseEntity.status(HttpStatus.OK).body("Pedido enviado via JMS!");
    }
}
