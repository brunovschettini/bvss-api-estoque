package br.com.bvss.es6.api.estoque.domain.produto.entity;

import br.com.bvss.es6.api.estoque.domain.produto.enumerator.TipoProdutoEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProdutoEntity {

    private Long idProduto;
    private String descricaoProduto;
    private TipoProdutoEnum tipoProduto;
}
