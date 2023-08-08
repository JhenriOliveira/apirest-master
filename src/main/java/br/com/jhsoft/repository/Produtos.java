package br.com.jhsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jhsoft.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
