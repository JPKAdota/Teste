public class Notificacao {
    public static void enviarEmail(Cliente cliente, String mensagem) {
        // Lógica para enviar um e-mail para o cliente com a mensagem
        System.out.println("E-mail enviado para " + cliente.getNome() + ": " + mensagem);
    }

    public static void enviarSMS(Cliente cliente, String mensagem) {
        // Lógica para enviar um SMS para o cliente com a mensagem
        System.out.println("SMS enviado para " + cliente.getNome() + ": " + mensagem);
    }
}
