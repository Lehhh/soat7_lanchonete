package br.com.fiap.soat7.infrastructure.controllers.webhook;

import br.com.fiap.soat7.application.usecases.pedido.ConfirmarPagamentoPedidoUsecase;
import br.com.fiap.soat7.infrastructure.controllers.webhook.request.ConfirmarPagamentoWebhookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook/pedido")
public class WebhookPedidoController {

    private final ConfirmarPagamentoPedidoUsecase confirmarPagamentoPedidoUsecase;

    public WebhookPedidoController(ConfirmarPagamentoPedidoUsecase confirmarPagamentoPedidoUsecase) {
        this.confirmarPagamentoPedidoUsecase = confirmarPagamentoPedidoUsecase;
    }

    @PostMapping("/confirmar-pagamento")
    public ResponseEntity<Void> confirmarPagamento(@RequestBody ConfirmarPagamentoWebhookRequest request) {
        confirmarPagamentoPedidoUsecase.confirmarPagamento(request.getIdPedido());
        return ResponseEntity.ok().build();
    }
}