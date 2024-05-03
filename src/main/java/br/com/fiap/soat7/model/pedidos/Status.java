package br.com.fiap.soat7.model.pedidos;

public enum Status {
    READY("Na Fila"),PROGRESS("Preparando"),DONE("Pronto"),FINISH("Entregue");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
