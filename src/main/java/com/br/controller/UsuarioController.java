package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.RespostaModel;
import com.br.model.UsuarioModel;
import com.br.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepository acoes;

    // Listar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public @ResponseBody List<UsuarioModel> listar() {
        return acoes.findAll();
    }

    // Cadastrar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public @ResponseBody UsuarioModel cadastrar(@RequestBody UsuarioModel usuario) {

        return acoes.save(usuario);
    }

    // Filtrar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public @ResponseBody UsuarioModel filtrar(@PathVariable int id) {
        return acoes.findById(id);
    }

    // Alterar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/usuarios/", method = RequestMethod.PUT)
    public @ResponseBody UsuarioModel alterar(@RequestBody UsuarioModel usuario) {
        return acoes.save(usuario);
    }

    // Remover
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public @ResponseBody RespostaModel remover(@PathVariable Integer id) {

        RespostaModel resposta = new RespostaModel();

        try {

            UsuarioModel usuario = filtrar(id);
            this.acoes.delete(usuario);
            resposta.setMensagens("Usuário removido com sucesso");
        } catch (Exception e) {
            resposta.setMensagens("Falha ao deletar: " + e.getMessage());
        }

        return resposta;
    }

}
