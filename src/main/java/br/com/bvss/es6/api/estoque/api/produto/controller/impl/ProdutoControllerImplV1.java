package br.com.bvss.es6.api.estoque.api.produto.controller.impl;

import br.com.bvss.es6.api.estoque.api.produto.controller.ProdutoControllerV1;
import br.com.bvss.es6.api.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoResponse;
import br.com.bvss.es6.api.estoque.usecase.produto.ProdutoUseCaseV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
public class ProdutoControllerImplV1 implements ProdutoControllerV1 {

    @Autowired
    @Qualifier("v1")
    private ProdutoUseCaseV1 produtoUseCase;

    @Override
    public ProdutoContractResponse getProdutoV1(final Long idProduto) {
        return produtoUseCase.getProdutoV1(idProduto);
    }

    @Override
    public ListaProdutoContractResponse getListaProdutosV1() {
        return produtoUseCase.getListaProdutosV1();
    }

    @Override
    public ListaProdutoContractResponse getListaArquivoProdutosV1() throws IOException {
        return produtoUseCase.getListaArquivoProdutosV1();
    }

    @Override
    public ResponseEntity<ProdutoResponse> postProdutoV1(final ProdutoRequest produtoRequest, final UriComponentsBuilder uriBuilder) {
        var produtoResponse = produtoUseCase.postProdutoV1(produtoRequest);
        URI endereco = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoResponse.getIdProduto()).toUri();
        return ResponseEntity.created(endereco).body(produtoResponse);
    }

    @Override
    public ResponseEntity<ProdutoResponse> putProdutoV1(final Long idProduto, final ProdutoRequest produtoRequest) {
        var produtoResponse = produtoUseCase.putProdutoV1(idProduto, produtoRequest);
        return ResponseEntity.ok(produtoResponse);
    }

    @Override
    public ResponseEntity deleteProdutoV1(final Long idProduto) {
        produtoUseCase.deleteProdutoV1(idProduto);
        return ResponseEntity.noContent().build();
    }
}
