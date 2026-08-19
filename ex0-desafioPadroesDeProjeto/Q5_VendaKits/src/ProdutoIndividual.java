/**
 * Leaf (Folha) do padrao Composite.
 *
 * Representa um item unitario do catalogo: nao possui filhos e seu preco e um
 * valor fixo definido na criacao.
 */
public class ProdutoIndividual extends Produto {
    private final double preco;

    public ProdutoIndividual(int id, String nome, double preco) {
        super(id, nome);
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String descrever(int nivel) {
        return String.format("%s- %s: %.2f%n", indentar(nivel), getNome(), getPreco());
    }
}
