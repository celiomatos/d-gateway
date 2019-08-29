package br.com.dgateway.controller;

import br.com.dgateway.model.Classificacao;
import br.com.dgateway.model.Page;
import br.com.dgateway.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classificacoes")
public class ClassificacaoController {

    @Autowired
    private MainService mainService;

    @GetMapping("/find-all")
    public Page<Classificacao> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return mainService.findAllClassificacoes(page, count, order, sortProperty);
    }

    @GetMapping("/find-by-nome/{nome}")
    public Page<Classificacao> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return mainService.findClassificacaoByName(nome, page, count, order, sortProperty);
    }
}
