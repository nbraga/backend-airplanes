package com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.model.PromocaoModel;

@Repository
public interface PromocaoRepository extends JpaRepository<PromocaoModel, Integer> {
    // Listar
    List<PromocaoModel> findAll();

    // Pesquisar
    PromocaoModel findById(int id);

    // Remover
    void delete(PromocaoModel promocao);

    // Cadastrar / Alterar
    <PromocaoMod extends PromocaoModel> PromocaoMod save(PromocaoMod promocao);
}