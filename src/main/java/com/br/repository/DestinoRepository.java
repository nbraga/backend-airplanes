package com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.model.DestinoModel;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Integer> {
    // Listar
    List<DestinoModel> findAll();

    // Pesquisar
    DestinoModel findById(int id);

    // Remover
    void delete(DestinoModel destino);

    // Cadastrar / Alterar
    <DestinoMod extends DestinoModel> DestinoMod save(DestinoMod destino);
}
