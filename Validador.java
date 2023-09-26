public class Validador {
    public static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica dígitos verificadores
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = 11 - (soma % 11);
        if (resto == 10 || resto == 11) {
            resto = 0;
        }
        if (resto != cpf.charAt(9) - '0') {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = 11 - (soma % 11);
        if (resto == 10 || resto == 11) {
            resto = 0;
        }
        if (resto != cpf.charAt(10) - '0') {
            return false;
        }

        return true;
    }

    public static boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            soma += (cnpj.charAt(i) - '0') * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : 11 - resto;

        // Cálculo do segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            soma += (cnpj.charAt(i) - '0') * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : 11 - resto;

        // Verifica os dígitos verificadores
        return (cnpj.charAt(12) - '0' == digitoVerificador1) && (cnpj.charAt(13) - '0' == digitoVerificador2);
    }
}
