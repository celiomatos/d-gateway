package br.com.dgateway.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    private long id;
    private Date data;
    private String nrOb;
    private String nrNl;
    private String nrNe;
    private BigDecimal valor;
    private Date lancamento;
    private boolean removido;
    private Classificacao classificacao;
    private Credor credor;
    private Fonte fonte;
    private Orgao orgao;

}
