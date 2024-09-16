package com.example.clientepicpay.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 4)
    private String numero_conta;

    private double saldo;
    private double limite_especial;
    private String cpf;


    public Conta() {
    }

    public String getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(String numero_conta) {
        int soma = 0;
        for (int i = 0; i < numero_conta.length(); i++) {
            soma += Character.getNumericValue(numero_conta.charAt(i));
            int divisao = soma % 10;
        }
        this.numero_conta = numero_conta + "divisao";
    }

    public double getLimite_especial() {
        return limite_especial;
    }

    public void setLimite_especial(double limite_especial) {
        this.limite_especial = limite_especial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
