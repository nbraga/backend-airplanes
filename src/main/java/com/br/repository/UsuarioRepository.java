package com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    // Listar
    List<UsuarioModel> findAll();

    // Pesquisar
    UsuarioModel findById(int id);

    // Remover
    void delete(UsuarioModel usuario);

    // Cadastrar / Alterar
    <UsuarioMod extends UsuarioModel> UsuarioMod save(UsuarioMod usuario);
}
