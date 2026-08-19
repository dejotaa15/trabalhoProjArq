import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Produto> catalogo = montarCatalogo();

        System.out.println("CATALOGO DISPONIVEL");
        for (Produto produto : catalogo) {
            System.out.print(produto.descrever(0));
        }
        System.out.println();

        VendasFachada proc = new VendasEmMemoria(catalogo);
        List<Produto> produtos = proc.buscarProdutos();

        Venda venda = proc.iniciarVenda();
        proc.registrarVenda(venda, produtos.get(0).getId(), 1);
        proc.registrarVenda(venda, produtos.get(1).getId(), 2);
        proc.registrarVenda(venda, produtos.get(3).getId(), 1);
        proc.registrarVenda(venda, produtos.get(4).getId(), 3);

        System.out.println(proc.emitirComprovante(venda));
    }

    /**
     * Monta o catalogo injetado na fachada, combinando folhas e compostos.
     *
     * O "Kit Escritorio" contem produtos individuais e tambem o "Kit Escrita",
     * formando um kit de kits: uma arvore com mais de um nivel de profundidade.
     */
    private static List<Produto> montarCatalogo() {
        ProdutoIndividual caneta = new ProdutoIndividual(1, "Caneta", 1.55);
        ProdutoIndividual borracha = new ProdutoIndividual(2, "Borracha", 1.15);
        ProdutoIndividual caderno = new ProdutoIndividual(3, "Caderno", 32.99);
        ProdutoIndividual lapis = new ProdutoIndividual(4, "Lapis", 2.40);
        ProdutoIndividual agenda = new ProdutoIndividual(5, "Agenda", 24.90);

        KitProduto kitEscrita = new KitProduto(100, "Kit Escrita");
        kitEscrita.adicionar(caneta);
        kitEscrita.adicionar(lapis);
        kitEscrita.adicionar(borracha);

        KitProduto kitEscritorio = new KitProduto(200, "Kit Escritorio");
        kitEscritorio.adicionar(kitEscrita);
        kitEscritorio.adicionar(caderno);
        kitEscritorio.adicionar(agenda);

        List<Produto> catalogo = new ArrayList<>();
        catalogo.add(caneta);
        catalogo.add(borracha);
        catalogo.add(caderno);
        catalogo.add(kitEscrita);
        catalogo.add(kitEscritorio);
        return catalogo;
    }
}
