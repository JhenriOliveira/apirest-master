package br.com.jhsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhsoft.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

}
