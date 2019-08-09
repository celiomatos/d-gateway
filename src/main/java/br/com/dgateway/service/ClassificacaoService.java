package br.com.dgateway.service;

import br.com.dgateway.model.Classificacao;
import br.com.dgateway.model.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "d-server-main", path = "classificacoes")
public interface ClassificacaoService {

    @GetMapping("/find-all")
    Page<Classificacao> findAll(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/find-by-nome/{nome}")
    Page<Classificacao> findByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);
}
