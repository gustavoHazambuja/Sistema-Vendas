package sistema_vendas.data;

import sistema_vendas.domain.entities.Produto;

public interface ProdutoRepository {
    Produto findByCodigo(int codigo);
    void salvar(Produto produto);
}