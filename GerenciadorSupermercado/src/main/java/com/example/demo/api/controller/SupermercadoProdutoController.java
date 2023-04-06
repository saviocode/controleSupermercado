package com.example.demo.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.model.SupermercadoProduto;
import com.example.demo.api.model.dto.SupermercadoProdutoDTO;
import com.example.demo.api.service.SupermercadoProdutoService;

@RestController
@RequestMapping("/supermercado-produto")
public class SupermercadoProdutoController {

    @Autowired
    private SupermercadoProdutoService service;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping(value = "/supermercado/{idSupermercado}")
    public ResponseEntity<List<SupermercadoProdutoDTO>> findAll(@PathVariable long idSupermercado,
            @RequestParam(required = false) String nome)
            throws Exception {
        return ResponseEntity.ok(
                service.findAll(idSupermercado, nome).stream().map(o -> mapper.map(o, SupermercadoProdutoDTO.class))
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SupermercadoProdutoDTO> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(mapper.map(service.findById(id), SupermercadoProdutoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody SupermercadoProdutoDTO objeto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(mapper.map(objeto, SupermercadoProduto.class)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody SupermercadoProdutoDTO objeto, @PathVariable long id)
            throws Exception {
        service.update(mapper.map(objeto, SupermercadoProduto.class), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
