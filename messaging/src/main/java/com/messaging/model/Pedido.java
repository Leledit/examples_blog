package com.messaging.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pedido implements Serializable {
    private String id;
    private String produto;
    private int quantidade;
}
