package br.com.fiap.soat7.infrastructure.controllers.webhook.request;

import br.com.fiap.soat7.domain.types.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConfirmarPagamentoWebhookRequest {
    private Long idPedido;
    @JsonIgnore
    private StatusPagamento statusPagamento;
}