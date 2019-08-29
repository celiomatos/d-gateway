package br.com.dgateway.controller;

import br.com.dgateway.model.Fonte;
import br.com.dgateway.model.Page;
import br.com.dgateway.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fontes")
public class FonteController {

    @Autowired
    private MainService mainService;

    @GetMapping("/find-all")
    public Page<Fonte> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return mainService.findAllFontes(page, count, order, sortProperty);
    }

    @GetMapping("/find-by-nome/{nome}")
    public Page<Fonte> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return mainService.findFonteByName(nome, page, count, order, sortProperty);
    }
}
