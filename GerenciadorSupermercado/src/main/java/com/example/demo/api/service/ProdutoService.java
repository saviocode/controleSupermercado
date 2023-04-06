package com.example.demo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.demo.api.model.Produto;
import com.example.demo.api.repository.ProdutoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(Produto objeto) throws IllegalArgumentException {
        validate(objeto);
        return repository.save(objeto).getId();
    }

    @Transactional
    public void update(Produto objeto, Long id) throws IllegalArgumentException {
        objeto.setId(findById(id).getId());
        save(objeto);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Produto não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<Produto> findAll(String nome) {
        if (StringUtils.hasText(nome)) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);

            Root<Produto> root = cq.from(Produto.class);
            Predicate nomePredicate = cb.like(root.get("nome"), "%" + nome + "%");
            cq.where(nomePredicate);
            cq.orderBy(cb.asc(root.get("nome")));
            return em.createQuery(cq).getResultList();
        } else {
            return repository.findAll(Sort.by(Direction.ASC, "nome"));
        }
    }

    private void validate(Produto objeto) throws IllegalArgumentException {
        if (!StringUtils.hasText(objeto.getNome())) {
            throw new IllegalArgumentException("Nome do Produto deve ser informado.");
        }
    }
}
