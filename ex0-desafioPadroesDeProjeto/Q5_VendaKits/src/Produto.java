/**
 * Component (Componente) do padrao Composite.
 *
 * Define a interface comum a todos os elementos da hierarquia de produtos,
 * sejam eles itens unitarios (Leaf) ou agrupamentos (Composite). Os clientes
 * do sistema (ItemDeVenda, Venda, VendasEmMemoria) dependem exclusivamente
 * desta abstracao, e por isso tratam produtos simples e kits de forma uniforme.
 */
public abstract class Produto {
    private final int id;
    private final String nome;

    protected Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Preco do produto.
     *
     * Nas folhas o valor e fixo; nos compostos e calculado recursivamente a
     * partir dos componentes.
     *
     * @return o preco do produto
     */
    public abstract double getPreco();

    /**
     * Descreve o produto e, no caso dos compostos, toda a sua arvore interna.
     *
     * @param nivel profundidade do item na hierarquia, usada para indentacao
     * @return uma String representando a estrutura do produto
     */
    public abstract String descrever(int nivel);

    protected String indentar(int nivel) {
        return "  ".repeat(nivel);
    }

    @Override
    public String toString() {
        return String.format("%d %s (%.2f)", id, nome, getPreco());
    }
}
