package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
