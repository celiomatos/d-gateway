package br.com.dgateway.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Classificacao {

    private long id;
    private String codigo;
    private String nome;

    public Classificacao(Long id) {
        this.id = id;
    }
}
