package com.example.clientepicpay.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Pedido {
    @Id
    private int id;
    private int cliente_id;
    private Date data_pedido;
    private String status;
    private double total_pedido;

    public Pedido(){

    }

}
