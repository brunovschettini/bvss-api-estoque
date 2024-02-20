package br.com.bvss.estoque.usecase.produto;


import br.com.bvss.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.estoque.domain.produto.response.ProdutoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoUseCase {

    ProdutoResponse getProduto(Long idProduto);

    Page<ProdutoResponse> getProdutos(Pageable paginacao);

    ProdutoResponse postProduto(ProdutoRequest produtoRequest);

    ProdutoResponse putProduto(Long idProduto, ProdutoRequest produtoRequest);

    void deleteProduto(Long idProduto);

}
