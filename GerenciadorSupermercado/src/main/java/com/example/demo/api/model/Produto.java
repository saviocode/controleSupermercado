package com.example.demo.api.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "produto")
/*
 * Classe referente a Produto
 */
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String codBarras;

    private String categoria;
    

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private List<SupermercadoProduto> supermercadoProdutos;

 
}
