package com.example.clientepicpay.repository;

import com.example.clientepicpay.models.Cliente;
import com.example.clientepicpay.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
