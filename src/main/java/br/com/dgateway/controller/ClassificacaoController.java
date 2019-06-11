package br.com.dgateway.controller;

import br.com.dgateway.model.Classificacao;
import br.com.dgateway.model.Page;
import br.com.dgateway.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classificacoes")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService classificacaoService;

    @GetMapping("/find-all")
    public Page<Classificacao> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return classificacaoService.findAll(page, count, order, sortProperty);
    }

    @GetMapping("/find-by-nome/{nome}")
    public Page<Classificacao> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return classificacaoService.findByName(nome, page, count, order, sortProperty);
    }
}
