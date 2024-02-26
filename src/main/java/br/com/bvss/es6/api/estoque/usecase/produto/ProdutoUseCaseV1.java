package br.com.bvss.es6.api.estoque.usecase.produto;


import br.com.bvss.es6.api.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoResponse;

import java.io.IOException;

public interface ProdutoUseCaseV1 {

    ProdutoContractResponse getProdutoV1(Long idProduto);

    ListaProdutoContractResponse getListaProdutosV1();

    ListaProdutoContractResponse getListaArquivoProdutosV1() throws IOException;

    ProdutoResponse postProdutoV1(ProdutoRequest produtoRequest);

    ProdutoResponse putProdutoV1(Long idProduto, ProdutoRequest produtoRequest);

    void deleteProdutoV1(Long idProduto);

}
