package br.com.dgateway.controller;

import br.com.dgateway.model.Orgao;
import br.com.dgateway.model.Page;
import br.com.dgateway.model.TopFiveOrgaosDto;
import br.com.dgateway.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoService orgaoService;

    @GetMapping("/top-five")
    public List<TopFiveOrgaosDto> topFive(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal) {
        return orgaoService.topFive(dateInicial, dateFinal);
    }

    @GetMapping("/find-all")
    public Page<Orgao> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {
        return orgaoService.findAll(page, count, order, sortProperty);
    }

    @GetMapping("/find-by-nome/{nome}")
    public Page<Orgao> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty) {
        return orgaoService.findByName(nome, page, count, order, sortProperty);
    }
}
