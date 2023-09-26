import java.math.BigDecimal;

public class Empresa {
    private String cnpj;
    private String nome;
    private BigDecimal saldo;
    private BigDecimal taxa;

    public Empresa(String cnpj, String nome, BigDecimal taxa) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.saldo = BigDecimal.ZERO;
        this.taxa = taxa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void processarTransacao(Transacao transacao) {
        BigDecimal valorComTaxa = transacao.getValor().multiply(taxa);
        if (valorComTaxa.compareTo(BigDecimal.ZERO) > 0 && transacao.getCliente().getSaldo().compareTo(valorComTaxa) >= 0) {
            saldo = saldo.add(valorComTaxa);
            transacao.getCliente().sacar(valorComTaxa);
            enviarCallback(transacao);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor inválido para a transação.");
        }
    }

    private void enviarCallback(Transacao transacao) {
        // Lógica para enviar o callback para a Empresa
        System.out.println("Callback enviado para a empresa: Transação realizada com sucesso.");
    }
}
