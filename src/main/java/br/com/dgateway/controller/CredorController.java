package br.com.dgateway.controller;

import br.com.dgateway.model.Credor;
import br.com.dgateway.model.Page;
import br.com.dgateway.model.TopFiveCredoresDto;
import br.com.dgateway.service.CredorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credores")
public class CredorController {

    @Autowired
    private CredorService credorService;

    @GetMapping("/top-five")
    public List<TopFiveCredoresDto> topFiveCredores(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal) {
        return credorService.topFiveCredores(dateInicial, dateFinal);
    }

    @GetMapping("/find-all")
    public Page<Credor> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return credorService.findAll(page, count, order, sortProperty);
    }

    @GetMapping("/find-by-nome/{nome}")
    public Page<Credor> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {

        return credorService.findByName(nome, page, count, order, sortProperty);
    }
}
