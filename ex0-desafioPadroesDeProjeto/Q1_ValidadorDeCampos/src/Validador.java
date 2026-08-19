import java.util.HashMap;
import java.util.Map;

public class Validador {

    private final Map<String, ValidadorInterface> validadores = new HashMap<>();

    public Validador() {
        registrar("EMAIL", new EmailValidador());
        registrar("INTEIRO", new InteiroValidador());
        registrar("MATRICULA", new MatriculaValidador());
    }

    public void registrar(String tipo, ValidadorInterface validador) {
        validadores.put(tipo, validador);
    }

    public boolean valida(String tipo, String valor) {
        ValidadorInterface validador = validadores.get(tipo);
        return validador.valida(valor);
    }
}