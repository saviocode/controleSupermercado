package com.example.demo.api.service;

import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.demo.api.model.Supermercado;
import com.example.demo.api.repository.SupermercadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SupermercadoService {

    private SupermercadoRepository repository;

    @PersistenceContext
    private EntityManager em;

    private SupermercadoProdutoService supermercadoProdutoService;

    @Transactional
    public Long save(Supermercado objeto) throws IllegalArgumentException {
        validate(objeto);
        repository.save(objeto);
        supermercadoProdutoService.saveAll(objeto.getSupermercadoProdutos(), objeto.getId());
        return objeto.getId();
    }

    @Transactional
    public void update(Supermercado objeto, Long id) throws IllegalArgumentException {
        objeto.setId(findById(id).getId());
        save(objeto);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Supermercado findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Supermercado não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<Supermercado> findAll(String nome) {
        if (StringUtils.hasText(nome)) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Supermercado> cq = cb.createQuery(Supermercado.class);

            Root<Supermercado> root = cq.from(Supermercado.class);
            Predicate nomePredicate = cb.like(root.get("nome"), "%" + nome + "%");
            cq.where(nomePredicate);
            cq.orderBy(cb.asc(root.get("nome")));
            return em.createQuery(cq).getResultList();
        } else {
            return repository.findAll(Sort.by(Direction.ASC, "nome"));
        }
    }

    private void validate(Supermercado objeto) throws IllegalArgumentException {
        if (!StringUtils.hasText(objeto.getNome())) {
            throw new IllegalArgumentException("Nome do Supermercado deve ser informado.");
        }
    }
}
