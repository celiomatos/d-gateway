package br.com.dgateway.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fonte {

    private String id;
    private String nome;

    public Fonte(String id) {
        this.id = id;
    }
}