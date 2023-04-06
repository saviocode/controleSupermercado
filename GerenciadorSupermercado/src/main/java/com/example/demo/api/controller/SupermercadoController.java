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

import com.example.demo.api.model.Supermercado;
import com.example.demo.api.model.dto.SupermercadoDTO;
import com.example.demo.api.service.SupermercadoService;

@RestController
@RequestMapping("/supermercado")
public class SupermercadoController {

    @Autowired
    private SupermercadoService service;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity<List<SupermercadoDTO>> findAll(@RequestParam(required = false) String nome) throws Exception {
        return ResponseEntity.ok(
                service.findAll(nome).stream().map(o -> mapper.map(o, SupermercadoDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SupermercadoDTO> findById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(mapper.map(service.findById(id), SupermercadoDTO.class));
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody SupermercadoDTO objeto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(mapper.map(objeto, Supermercado.class)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody SupermercadoDTO objeto, @PathVariable long id) throws Exception {
        service.update(mapper.map(objeto, Supermercado.class), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) throws Exception {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
