import java.math.BigDecimal;

public class Cliente {
    private String cpf;
    private String nome;
    private BigDecimal saldo;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.saldo = BigDecimal.ZERO;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
        } else {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && saldo.compareTo(valor) >= 0) {
            saldo = saldo.subtract(valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor inválido para saque.");
        }
    }
}
