package br.com.dgateway.service;

import br.com.dgateway.model.Orgao;
import br.com.dgateway.model.Page;
import br.com.dgateway.model.TopFiveOrgaosDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(name = "orgaoService", url = "http://localhost:8084/orgaos")
public interface OrgaoService {

    @GetMapping("/top-five")
    List<TopFiveOrgaosDto> topFive(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal);

    @GetMapping("/find-all")
    Page<Orgao> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/find-by-nome/{nome}")
    Page<Orgao> findByName(@PathVariable String nome,
                           @RequestParam Integer page,
                           @RequestParam Integer count,
                           @RequestParam String order,
                           @RequestParam String sortProperty);
}
