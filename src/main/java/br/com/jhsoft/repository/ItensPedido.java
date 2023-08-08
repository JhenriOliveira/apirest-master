package br.com.jhsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhsoft.entity.ItemPedido;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer>{

}
