package br.com.dgateway.service;

import br.com.dgateway.model.FiveYearsDto;
import br.com.dgateway.model.Pagamento;
import br.com.dgateway.model.PagamentoSearchDto;
import br.com.dgateway.model.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
@FeignClient(name = "pagamentoService", url = "http://d-server-main:8084/pagamentos")
public interface PagamentoService {

    @PostMapping("/search")
    Page<Pagamento> findPagamentos(@RequestBody PagamentoSearchDto pagSearchDto);

    @PostMapping("/sum-pagamento-valor")
    BigDecimal sumPagamentoValor(@RequestBody PagamentoSearchDto pagSearchDto);

    @GetMapping("/five-years")
    List<FiveYearsDto> fiveYearsPagagmentos();

    @PostMapping("/pagamentos-to-excell")
    byte[] pagamentosToExcell(@RequestBody PagamentoSearchDto pagSearchDto);
}
