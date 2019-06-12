package br.com.dgateway.controller;

import br.com.dgateway.model.FiveYearsDto;
import br.com.dgateway.model.Pagamento;
import br.com.dgateway.model.PagamentoSearchDto;
import br.com.dgateway.model.Page;
import br.com.dgateway.service.PagamentoService;
import com.google.common.io.ByteSource;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/search")
    public Page<Pagamento> findPagamentos(@RequestBody @Valid PagamentoSearchDto pagSearchDto) {
        return pagamentoService.findPagamentos(pagSearchDto);
    }

    @PostMapping("/sum-pagamento-valor")
    public BigDecimal sumPagamentoValor(@RequestBody PagamentoSearchDto pagSearchDto) {
        return pagamentoService.sumPagamentoValor(pagSearchDto);
    }

    @GetMapping("/five-years")
    public List<FiveYearsDto> fiveYearsPagagmentos() {
        return pagamentoService.fiveYearsPagagmentos();
    }

    @PostMapping("/pagamentos-to-excell")
    public void pagamentosToExcell(@RequestBody PagamentoSearchDto pagSearchDto) throws IOException {

        byte[] bytes = pagamentoService.pagamentosToExcell(pagSearchDto);
        try (InputStream targetStream = ByteSource.wrap(bytes).openStream()) {
            response.addHeader("Content-disposition", "attachment;filename=sample.xlsx");
            response.setContentType("application/vnd.ms-excel");
            IOUtils.copy(targetStream, response.getOutputStream());
        }
        response.flushBuffer();
    }
}
