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

import com.br.model.PromocaoModel;
import com.br.model.RespostaModel;
import com.br.repository.PromocaoRepository;

@RestController
@RequestMapping("/api")
public class PromocaoController {

    @Autowired
    private PromocaoRepository acoes;

    // Listar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/promocoes", method = RequestMethod.GET)
    public @ResponseBody List<PromocaoModel> listar() {
        return acoes.findAll();
    }

    // Cadastrar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/promocoes", method = RequestMethod.POST)
    public @ResponseBody PromocaoModel cadastrar(@RequestBody PromocaoModel promocao) {

        return acoes.save(promocao);
    }

    // Filtrar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/promocoes/{id}", method = RequestMethod.GET)
    public @ResponseBody PromocaoModel filtrar(@PathVariable int id) {
        return acoes.findById(id);
    }

    // Alterar
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/promocoes", method = RequestMethod.PUT)
    public @ResponseBody PromocaoModel alterar(@RequestBody PromocaoModel usuario) {
        return acoes.save(usuario);
    }

    // Remover
    @RequestMapping(value = "/promocoes/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*")
    public @ResponseBody RespostaModel remover(@PathVariable Integer id) {

        RespostaModel resposta = new RespostaModel();

        try {

            PromocaoModel promocao = filtrar(id);
            this.acoes.delete(promocao);
            resposta.setMensagens("Promocao removido com sucesso");
        } catch (Exception e) {
            resposta.setMensagens("Falha ao deletar: " + e.getMessage());
        }

        return resposta;
    }

}
