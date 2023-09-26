import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US); // Defina o Locale para US (ponto como separador decimal)

        System.out.println("Bem-vindo ao Sistema Bancário!");
        // Criação de Cliente e Empresa
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o nome do Cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(cpf, nomeCliente);

        System.out.print("Digite o CNPJ da Empresa: ");
        String cnpj = scanner.nextLine();
        System.out.print("Digite o nome da Empresa: ");
        String nomeEmpresa = scanner.nextLine();
        System.out.print("Digite a taxa de sistema da Empresa (por exemplo, 0.05 para 5%): ");
        BigDecimal taxaEmpresa = scanner.nextBigDecimal();
        Empresa empresa = new Empresa(cnpj, nomeEmpresa, taxaEmpresa);

        // Realiza transações
        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Depósito");
            System.out.println("2. Saque");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Depósito
                    System.out.print("Digite o valor do depósito: ");
                    String valorDepositoStr = scanner.next().replace(',', '.'); // Substitui ',' por '.' se necessário
                    BigDecimal valorDeposito = new BigDecimal(valorDepositoStr);
                    if (valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
                        System.out.println("Valor do depósito deve ser maior que zero.");
                    } else {
                        cliente.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                    }
                    break;


                case 2:
                    try {
                        System.out.print("Digite o valor do saque: ");
                        BigDecimal valorSaque = scanner.nextBigDecimal();
                        cliente.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso.");
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Digite um valor numérico válido.");
                        scanner.nextLine(); // Limpar o buffer de entrada
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Saindo do Sistema Bancário.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            // Processa transações na empresa
            Transacao transacao = new Transacao(cliente, empresa, BigDecimal.ZERO);
            empresa.processarTransacao(transacao);

            // Mostra saldos
            System.out.println("\nSaldo do Cliente: " + cliente.getSaldo());
            System.out.println("Saldo da Empresa: " + empresa.getSaldo());
        }
    }
}
