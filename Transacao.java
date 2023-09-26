import java.math.BigDecimal;

public class Transacao {
    private Cliente cliente;
    private Empresa empresa;
    private BigDecimal valor;

    public Transacao(Cliente cliente, Empresa empresa, BigDecimal valor) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void realizarTransacao() {
        empresa.processarTransacao(this);
        Notificacao.enviarEmail(cliente, "Sua transação foi processada com sucesso.");
    }
}
