package com.barbeariacx.BarbeariaCX.repository;

import com.barbeariacx.BarbeariaCX.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
