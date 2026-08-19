public class App {
    public static void main(String[] args) {
        ProcessadorDePagamento pix = new PagamentoPix();
        pix.pagar(150.00);

        // O serviço de cartão possui uma interface incompatível com
        // ProcessadorDePagamento e precisa ser utilizado de outra forma.
        ServicoCartao cartao = new ServicoCartao();
        cartao.autorizar("1234-5678-9012-3456", 15000);
    }
}
