public class PagamentoPix implements ProcessadorDePagamento {
    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento PIX de R$ %.2f realizado.%n", valor);
    }
}
