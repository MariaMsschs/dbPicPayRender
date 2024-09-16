package com.example.clientepicpay.controllers;

import com.example.clientepicpay.models.Cliente;
import com.example.clientepicpay.repository.ClienteRepository;
import com.example.clientepicpay.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//a url padrão sempre vai ser api/produtos

//• Criar uma API para fazer um CRUD dessas tabelas usando Spring
// MVC em Java com estrutura do projeto que inclui os pacotes controller e service

//• Fazer as validações das entradas recebidas pela API e tratar exceções com respostas HTTP
// apropriadas para o cliente

//• Criar as requisições HTTP para testar os métodos da API

//• Cliente:
//        o Criar métodos para fazer as operações básicas do CRUD por CPF e para selecionar
//        todos os registros
//        o Criar pelo menos mais três métodos de consulta derivados que ajudem na criação
//        de relatórios

@RestController
@RequestMapping("/api/banco")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    private ClienteController(ClienteRepository clienteRepository){
        this.clienteService = new ClienteService(clienteRepository);
    }

    @GetMapping("/selecionar")
    public List<Cliente> listarProdutos(){
        return clienteService.buscarClientes();
    }

    @GetMapping("/buscarCliente/{cpf}")
    public Cliente buscarUm(@PathVariable String cpf){
        return clienteService.buscarClientePorCpf(cpf);
    }

    @DeleteMapping("/excluirCliente/{cpf}")
    public Cliente excluirCliente(@PathVariable String cpf) {
        return clienteService.excluirCliente(cpf);
    }

    @GetMapping("/inserirCliente")
    public ResponseEntity<String> inserirCliente(@RequestBody Cliente cliente){
        clienteService.salvarCliente(cliente);
        return ResponseEntity.ok("Cliente inserido com sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable String cpf, @RequestBody Cliente clienteAtualizado){
        Cliente clienteExistente = clienteService.buscarClientePorCpf(cpf);

        Cliente cliente = clienteExistente;
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        clienteService.salvarCliente(cliente);
        return ResponseEntity.ok("Produto atualizado com sucesso");
    }
}
