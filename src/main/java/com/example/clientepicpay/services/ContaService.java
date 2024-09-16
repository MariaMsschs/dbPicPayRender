package com.example.clientepicpay.services;

import com.example.clientepicpay.models.Cliente;
import com.example.clientepicpay.models.Conta;
import com.example.clientepicpay.repository.ContaRepository;

import java.util.List;

public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }

    public Conta salvarConta(Conta conta){
        return contaRepository.save(conta);
    }

    public List<Conta> buscarContas(){
        return contaRepository.findAll();
    }
//
//    public Conta sacar(double valor){
//
//    }
}
