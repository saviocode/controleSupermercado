package com.example.demo.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.api.model.SupermercadoProduto;

public interface SupermercadoProdutoRepository extends JpaRepository<SupermercadoProduto, Long> {

    List<SupermercadoProduto> findBySupermercadoId(Long idSupermercado, Sort sort);

    boolean existsBySupermercadoIdAndProdutoIdAndIdNot(Long supermercadoId, Long produtoId, Long id);
}
