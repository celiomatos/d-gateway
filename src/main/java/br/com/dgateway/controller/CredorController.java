package br.com.dgateway.controller;

import br.com.dgateway.model.Credor;
import br.com.dgateway.model.Page;
import br.com.dgateway.model.TopFiveCredoresDto;
import br.com.dgateway.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credores")
public class CredorController {

    @Autowired
    private MainService mainService;

    @GetMapping("/top-five")
    public List<TopFiveCredoresDto> topFiveCredores(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal) {
        return mainService.topFiveCredores(dateInicial, dateFinal);
    }

    @GetMapping("/find-all")
    public Page<Credor> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return mainService.findAllCredores(page, count, order, sortProperty);
    }

    @GetMapping("/find-by-nome/{nome}")
    public Page<Credor> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return mainService.findCredorByName(nome, page, count, order, sortProperty);
    }
}
