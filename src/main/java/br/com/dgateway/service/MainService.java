package br.com.dgateway.service;

import br.com.dgateway.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Service
@FeignClient("d-server-main")
public interface MainService {

    /**
     * Fontes
     * @param page
     * @param count
     * @param order
     * @param sortProperty
     * @return
     */
    @GetMapping("/fontes/find-all")
    Page<Fonte> findAllFontes(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/fontes/find-by-nome/{nome}")
    Page<Fonte> findFonteByName(@PathVariable String nome,
                                @RequestParam Integer page,
                                @RequestParam Integer count,
                                @RequestParam String order,
                                @RequestParam String sortProperty);

    /**
     * Orgaos
     * @param dateInicial
     * @param dateFinal
     * @return
     */
    @GetMapping("/orgaos/top-five")
    List<TopFiveOrgaosDto> topFiveOrgaos(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal);

    @GetMapping("/orgaos/find-all")
    Page<Orgao> findAllOrgaos(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/orgaos/find-by-nome/{nome}")
    Page<Orgao> findOrgaoByName(@PathVariable String nome,
                                @RequestParam Integer page,
                                @RequestParam Integer count,
                                @RequestParam String order,
                                @RequestParam String sortProperty);

    /**
     * Pagamentos
     * @param pagSearchDto
     * @return
     */
    @PostMapping("/pagamentos/search")
    Page<Pagamento> findPagamentos(@RequestBody PagamentoSearchDto pagSearchDto);

    @PostMapping("/pagamentos/sum-pagamento-valor")
    BigDecimal sumPagamentoValor(@RequestBody PagamentoSearchDto pagSearchDto);

    @GetMapping("/pagamentos/five-years")
    List<FiveYearsDto> fiveYearsPagagmentos();

    @PostMapping("/pagamentos/pagamentos-to-excell")
    byte[] pagamentosToExcell(@RequestBody PagamentoSearchDto pagSearchDto);

    /**
     * Classificacoes
     * @param page
     * @param count
     * @param order
     * @param sortProperty
     * @return
     */
    @GetMapping("/classificacoes/find-all")
    Page<Classificacao> findAllClassificacoes(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/classificacoes/find-by-nome/{nome}")
    Page<Classificacao> findClassificacaoByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    /**
     * Credores
     * @param dateInicial
     * @param dateFinal
     * @return
     */
    @GetMapping("/credores/top-five")
    List<TopFiveCredoresDto> topFiveCredores(
            @RequestParam String dateInicial,
            @RequestParam String dateFinal);

    @GetMapping("/credores/find-all")
    Page<Credor> findAllCredores(
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);

    @GetMapping("/credores/find-by-nome/{nome}")
    Page<Credor> findCredorByName(
            @PathVariable String nome,
            @RequestParam Integer page,
            @RequestParam Integer count,
            @RequestParam String order,
            @RequestParam String sortProperty);
}
