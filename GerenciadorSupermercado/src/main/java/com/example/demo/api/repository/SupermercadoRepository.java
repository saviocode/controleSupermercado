package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.api.model.Supermercado;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Long> {

}
