package br.com.bvss.estoque.controller.produto.impl;

import br.com.bvss.estoque.controller.produto.ProdutoController;

import br.com.bvss.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.estoque.domain.produto.response.ProdutoResponse;
import br.com.bvss.estoque.usecase.produto.ProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ProdutoControllerImpl implements ProdutoController {

    @Autowired
    private ProdutoUseCase produtoUseCase;

    @Override
    public ProdutoResponse getProduto(final Long idProduto) {
        return produtoUseCase.getProduto(idProduto);
    }

    @Override
    public Page<ProdutoResponse> getProdutos(final Pageable paginacao) {
        return produtoUseCase.getProdutos(paginacao);
    }

    @Override
    public ResponseEntity<ProdutoResponse> postProduto(final ProdutoRequest produtoRequest, final UriComponentsBuilder uriBuilder) {
        var produtoResponse = produtoUseCase.postProduto(produtoRequest);
        URI endereco = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoResponse.getIdProduto()).toUri();
        return ResponseEntity.created(endereco).body(produtoResponse);
    }

    @Override
    public ResponseEntity<ProdutoResponse> putProduto(final Long idProduto, final ProdutoRequest produtoRequest) {
        var produtoResponse = produtoUseCase.putProduto(idProduto, produtoRequest);
        return ResponseEntity.ok(produtoResponse);
    }

    @Override
    public ResponseEntity deleteProduto(final Long idProduto) {
        produtoUseCase.deleteProduto(idProduto);
        return ResponseEntity.noContent().build();
    }
}
