package com.example.demo.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "supermercado_produto", uniqueConstraints = {
                @UniqueConstraint(name = "UniqueSupermercadoAndProduto", columnNames = { "supermercado_id",
                                "produto_id" }) })
/*
 * Classe referente a SupermercadoProduto
 */
public class SupermercadoProduto implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Double preco;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "supermercado_id")
        private Supermercado supermercado;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "produto_id")
        private Produto produto;

        /**
         * Demas atributos
         */
}
