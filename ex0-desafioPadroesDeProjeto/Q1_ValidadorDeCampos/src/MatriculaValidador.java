public class MatriculaValidador implements ValidadorInterface {
    @Override
    public boolean valida(String valor) {
        for (int i = 0; i < valor.length(); i++) {
            if (!Character.isDigit(valor.charAt(i))) {
                return false;
            }
        }
        int sum = 0;
        for (int i = 0; i < valor.length() - 1; i++) {
            sum += Character.getNumericValue(valor.charAt(i));
        }
        int verificador = sum % 10;
        return verificador == Character.getNumericValue(valor.charAt(valor.length() - 1));
    }
}