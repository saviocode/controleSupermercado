package com.example.demo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.api.model.Supermercado;
import com.example.demo.api.model.SupermercadoProduto;
import com.example.demo.api.repository.SupermercadoProdutoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SupermercadoProdutoService {

    @Autowired
    private SupermercadoProdutoRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(SupermercadoProduto objeto) throws IllegalArgumentException {
        validate(objeto);
        return repository.save(objeto).getId();
    }

    @Transactional
    public void update(SupermercadoProduto objeto, Long id) throws IllegalArgumentException {
        objeto.setId(findById(id).getId());
        save(objeto);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public SupermercadoProduto findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Supermercado-Produto não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<SupermercadoProduto> findAll(Long idSupermercado, String nome) {
        if (idSupermercado == null || idSupermercado <= 0) {
            throw new IllegalArgumentException("ID do Supermercado deve ser informado.");
        }
        if (StringUtils.hasText(nome)) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<SupermercadoProduto> cq = cb.createQuery(SupermercadoProduto.class);

            Root<SupermercadoProduto> root = cq.from(SupermercadoProduto.class);
            final Predicate nomePredicate = cb.like(root.get("produto").get("nome"), "%" + nome + "%");
            final Predicate supermecadoPredicate = cb.equal(root.get("supermercado").get("id"), idSupermercado);
            cq.where(nomePredicate, supermecadoPredicate);
            cq.orderBy(cb.asc(root.get("produto").get("nome")));
            return em.createQuery(cq).getResultList();
        } else {
            return repository.findBySupermercadoId(idSupermercado, Sort.by(Direction.ASC, "produto.nome"));
        }
    }

    @Transactional
    public void saveAll(List<SupermercadoProduto> supermercadoProdutos, Long idSupermercado) {
        if (!CollectionUtils.isEmpty(supermercadoProdutos)) {
            final Supermercado supermercado = Supermercado.builder().id(idSupermercado).build();
            for (SupermercadoProduto objeto : supermercadoProdutos) {
                objeto.setSupermercado(supermercado);
                save(objeto);
            }
        }
    }

    private void validate(SupermercadoProduto objeto) throws IllegalArgumentException {
        if (objeto.getPreco() == null || objeto.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço do Produto deve ser informado.");
        }
        if (repository.existsBySupermercadoIdAndProdutoIdAndIdNot(objeto.getSupermercado().getId(),
                objeto.getProduto().getId(), objeto.getId() == null ? 0L : objeto.getId())) {
            throw new IllegalArgumentException("Produto já foi relacionado a esse Supermercado.");
        }
    }
}
