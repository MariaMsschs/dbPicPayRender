package com.example.clientepicpay.repository;

import com.example.clientepicpay.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
