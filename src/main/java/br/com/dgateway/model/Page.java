package br.com.dgateway.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    List<T> content;
    boolean first;
    boolean last;
    Integer numberOfElements;
    Integer size;
    Integer totalElements;
    Integer totalPages;
}
