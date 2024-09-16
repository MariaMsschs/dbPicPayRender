package com.example.clientepicpay.services;

import com.example.clientepicpay.models.Cliente;
import com.example.clientepicpay.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarClientes(){ return clienteRepository.findAll();}

    public Cliente buscarClientePorCpf(String cpf){
        return clienteRepository.findById(cpf).orElseThrow(() ->
                new RuntimeException("Produto não encontrado"));
    }

    public Cliente excluirCliente(String cpf){
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if(cliente.isPresent()){
            clienteRepository.deleteById(cpf);
            return cliente.get();
        }
        return null;
    }

//    public Optional<Cliente> excluirCliente(String cpf){
//        Optional<Cliente> cliente = clienteRepository.findById(cpf);
//
//        if(cliente.isPresent()){
//            clienteRepository.deleteById(cliente.get().getCpf());
//            return cliente;
//        }
//        return Optional.empty();
//    }
}
