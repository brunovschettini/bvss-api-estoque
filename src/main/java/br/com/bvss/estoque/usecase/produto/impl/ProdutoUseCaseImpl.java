package br.com.bvss.estoque.usecase.produto.impl;


import br.com.bvss.estoque.domain.produto.entity.ProdutoEntity;
import br.com.bvss.estoque.domain.produto.enumerator.TipoProdutoEnum;
import br.com.bvss.estoque.domain.produto.mapper.ProdutoMapper;
import br.com.bvss.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.estoque.domain.produto.response.ProdutoResponse;
import br.com.bvss.estoque.usecase.produto.ProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    private ProdutoMapper produtoMapper;

    public ProdutoResponse getProduto(final Long idProduto) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(1L)
                .descricaoProduto("Produto Teste")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return produtoResponse;
    }

    public Page<ProdutoResponse> getProdutos(Pageable paginacao) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(1L)
                .descricaoProduto("Produto Teste")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return (Page<ProdutoResponse>) Arrays.asList(produtoResponse);
    }

    public ProdutoResponse postProduto(final ProdutoRequest produtoRequest) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(2L)
                .descricaoProduto("Produto Teste 2")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return produtoResponse;
    }

    public ProdutoResponse putProduto(final Long idProduto, final ProdutoRequest produtoRequest) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(2L)
                .descricaoProduto("Produto Teste 2")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return produtoResponse;
    }

    public void deleteProduto(final Long idProduto) {
        return;
    }
}
