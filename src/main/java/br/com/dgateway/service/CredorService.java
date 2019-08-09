package br.com.dgateway.service;

import br.com.dgateway.model.Credor;
import br.com.dgateway.model.Page;
import br.com.dgateway.model.TopFiveCredoresDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "d-server-main", path = "credores")
public interface CredorService {

    @GetMapping("/top-five")
    List<TopFiveCredoresDto> topFiveCredores(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal);

    @GetMapping("/find-all")
    Page<Credor> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/find-by-nome/{nome}")
    Page<Credor> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);
}
