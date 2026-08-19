public class ServicoCartao {
    public void autorizar(String numeroDoCartao, int valorEmCentavos) {
        System.out.printf("Cartão %s autorizado no valor de R$ %.2f.%n",
                numeroDoCartao, valorEmCentavos / 100.0);
    }
}
