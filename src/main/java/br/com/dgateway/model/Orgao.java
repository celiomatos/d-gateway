package br.com.dgateway.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orgao {

    private long id;
    private String codigo;
    private String sigla;
    private String nome;
    private String orgName;
    private short esfera;

}