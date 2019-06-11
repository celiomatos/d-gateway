package br.com.dgateway.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credor {

    private long id;
    private String nome;
    private String codigo;

    public Credor(Long id) {
        this.id = id;
    }
}
