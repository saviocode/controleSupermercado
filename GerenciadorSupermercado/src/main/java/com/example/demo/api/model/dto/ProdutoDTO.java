package com.example.demo.api.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
/*
 * Classe referente a Produto
 */
public class ProdutoDTO implements Serializable {

    private Long id;
    private String nome;
    private String codBarras;
    private String categoria;

  
}
