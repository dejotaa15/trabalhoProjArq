public class App {
    public static void main(String[] args) throws Exception {
        var validador = new Validador();

        String email = "bernardo.copstein@pucrs.br";
        System.out.println(email + (validador.valida("EMAIL", email)
                ? " é um email válido!" : " não é um email válido!"));

        String inteiro = "a12345";
        System.out.println(inteiro + (validador.valida("INTEIRO", inteiro)
                ? " é um inteiro válido!" : " não é um inteiro válido!"));

        String matricula = "1236"; // soma dos dígitos (1+2+3=6) % 10 = 6 == último dígito
        System.out.println(matricula + (validador.valida("MATRICULA", matricula)
                ? " é uma matrícula válida!" : " não é uma matrícula válida!"));

        
        validador.registrar("CEP", new CepValidador());

        String cep = "90619-900";
        System.out.println(cep + (validador.valida("CEP", cep)
                ? " é um CEP válido!" : " não é um CEP válido!"));
    }
}


class CepValidador implements ValidadorInterface {
    @Override
    public boolean valida(String valor) {
        return valor != null && valor.matches("\\d{5}-\\d{3}");
    }
}