package br.com.fiap.soat7.domain.types;

import lombok.Getter;

@Getter
public enum StatusPedido {


    PRONTO("PRONTO",1),
    EM_PREPARACAO("EM PREPARACAO",2),
    RECEBIDO("RECEBIDO",3),
    FINALIZADO("FINALIZADO",4);

    private String value;
    private int order;

    StatusPedido(String value, int order) {
    }
}
