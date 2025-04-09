package com.messaging.jms;

import com.messaging.model.Pedido;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListenerJms {

    @JmsListener(destination = "fila.pedidos", containerFactory = "myFactory")
    public void processarPedido(Pedido pedido) {
        System.out.println("📩 [JMS] Pedido recebido: " + pedido);
        // Simular lógica de processamento (e-mail, estoque, etc.)
    }
}
