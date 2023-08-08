package br.com.jhsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhsoft.entity.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

}
