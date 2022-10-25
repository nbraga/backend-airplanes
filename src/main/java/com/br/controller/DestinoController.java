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

import com.br.model.DestinoModel;
import com.br.model.RespostaModel;
import com.br.repository.DestinoRepository;

@RestController
@RequestMapping("/api")
public class DestinoController {

    @Autowired
    private DestinoRepository acoes;

    // Listar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/destinos", method = RequestMethod.GET)
    public @ResponseBody List<DestinoModel> listar() {
        return acoes.findAll();
    }

    // Cadastrar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/destinos", method = RequestMethod.POST)
    public @ResponseBody DestinoModel cadastrar(@RequestBody DestinoModel destino) {

        return acoes.save(destino);
    }

    // Filtrar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/destinos/{id}", method = RequestMethod.GET)
    public @ResponseBody DestinoModel filtrar(@PathVariable int id) {
        return acoes.findById(id);
    }

    // Alterar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/destinos", method = RequestMethod.PUT)
    public @ResponseBody DestinoModel alterar(@RequestBody DestinoModel destino) {
        return acoes.save(destino);
    }

    // Remover
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/destinos/{id}", method = RequestMethod.DELETE)
    public @ResponseBody RespostaModel remover(@PathVariable Integer id) {

        RespostaModel resposta = new RespostaModel();

        try {

            DestinoModel destino = filtrar(id);
            this.acoes.delete(destino);
            resposta.setMensagens("Destino removido com sucesso");
        } catch (Exception e) {
            resposta.setMensagens("Falha ao deletar: " + e.getMessage());
        }

        return resposta;
    }

}
