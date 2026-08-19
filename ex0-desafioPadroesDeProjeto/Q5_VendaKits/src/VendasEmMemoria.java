import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementacao em memoria da fachada de vendas.
 *
 * O catalogo de produtos e recebido por injecao de dependencia pelo
 * construtor. A classe deixa de ser responsavel por criar os produtos e passa
 * a apenas orquestrar a venda, o que a desacopla dos tipos concretos da
 * hierarquia (ProdutoIndividual e KitProduto) e permite configurar catalogos
 * diferentes sem alterar esta classe.
 */
public class VendasEmMemoria implements VendasFachada {
	private final List<Produto> produtos;

	public VendasEmMemoria(List<Produto> produtos) {
		this.produtos = new ArrayList<>(produtos);
	}

	@Override
	public Venda iniciarVenda() {
		return new Venda(LocalDateTime.now());
	}

	@Override
	public void registrarVenda(Venda umaVenda, int codigoProduto, int quantidade) {
		Produto prod = produtos.stream()
				.filter(p -> p.getId() == codigoProduto)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(
						"Produto nao encontrado no catalogo: " + codigoProduto));
		umaVenda.registrarVenda(prod, quantidade);
	}

	@Override
	public String emitirComprovante(Venda umaVenda) {
		return umaVenda.emitirComprovante();
	}

	@Override
	public List<Produto> buscarProdutos() {
		return Collections.unmodifiableList(produtos);
	}

}
