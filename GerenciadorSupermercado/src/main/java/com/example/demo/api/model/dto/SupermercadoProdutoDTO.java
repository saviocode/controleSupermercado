package com.example.demo.api.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
/*
 * Classe referente a SupermercadoProduto
 */
public class SupermercadoProdutoDTO implements Serializable {

        private Long id;

        private Double preco;
        
        private ProdutoDTO produto;
        
        private SupermercadoDTO supermercado;

        /**
         * Demas atributos
         */
}
