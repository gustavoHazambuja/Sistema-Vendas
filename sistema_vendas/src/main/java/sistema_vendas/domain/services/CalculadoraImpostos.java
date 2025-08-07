package sistema_vendas.domain.services;

import sistema_vendas.domain.entities.CategoriaProduto;

public interface CalculadoraImpostos {
    
    double calcularValorFinal(CategoriaProduto categoriaProduto, double precoUnitario);
}
