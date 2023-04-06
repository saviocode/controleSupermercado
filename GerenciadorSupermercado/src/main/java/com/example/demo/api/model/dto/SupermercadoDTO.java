package com.example.demo.api.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
/*
 * Classe referente a Supermercado
 */
public class SupermercadoDTO implements Serializable {

    private Long id;

    private String nome;

    private String fone;

    private String  endereco;

}
