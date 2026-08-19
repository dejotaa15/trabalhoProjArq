import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Composite (Composto) do padrao Composite.
 *
 * Agrupa outros produtos, que podem ser folhas (ProdutoIndividual) ou outros
 * kits. Como a lista interna e do tipo Produto, um kit pode conter kits em
 * qualquer profundidade sem que a classe precise conhecer os tipos concretos.
 *
 * Os metodos de gerencia dos filhos (adicionar/remover) sao declarados apenas
 * aqui, e nao na abstracao Produto: e a abordagem de "seguranca" do padrao,
 * que impede em tempo de compilacao a tentativa de adicionar um filho a uma
 * folha.
 */
public class KitProduto extends Produto {
    private final List<Produto> componentes;

    public KitProduto(int id, String nome) {
        super(id, nome);
        this.componentes = new ArrayList<>();
    }

    public void adicionar(Produto produto) {
        componentes.add(produto);
    }

    public void remover(Produto produto) {
        componentes.remove(produto);
    }

    public List<Produto> getComponentes() {
        return Collections.unmodifiableList(componentes);
    }

    /**
     * Soma recursivamente o preco de todos os componentes do kit.
     *
     * Se um componente for outro kit, a propria chamada polimorfica a
     * getPreco() resolve o subtotal daquela sub-arvore.
     */
    @Override
    public double getPreco() {
        double total = 0.0;
        for (Produto componente : componentes) {
            total += componente.getPreco();
        }
        return total;
    }

    @Override
    public String descrever(int nivel) {
        StringBuilder descricao = new StringBuilder();
        descricao.append(String.format("%s+ %s (kit): %.2f%n", indentar(nivel), getNome(), getPreco()));
        for (Produto componente : componentes) {
            descricao.append(componente.descrever(nivel + 1));
        }
        return descricao.toString();
    }
}
