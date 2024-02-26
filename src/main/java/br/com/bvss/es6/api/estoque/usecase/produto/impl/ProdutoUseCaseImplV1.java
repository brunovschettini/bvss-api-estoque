package br.com.bvss.es6.api.estoque.usecase.produto.impl;


import br.com.bvss.es6.api.estoque.domain.produto.entity.ProdutoEntity;
import br.com.bvss.es6.api.estoque.domain.produto.enumerator.TipoProdutoEnum;
import br.com.bvss.es6.api.estoque.domain.produto.mapper.ProdutoMapper;
import br.com.bvss.es6.api.estoque.domain.produto.request.ProdutoRequest;/**/
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoResponse;
import br.com.bvss.es6.api.estoque.usecase.produto.ProdutoUseCaseV1;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
@Qualifier("v1")
public class ProdutoUseCaseImplV1 implements ProdutoUseCaseV1 {

    @Autowired
    private ProdutoMapper produtoMapper;

    @Value("classpath:./data/json/produto/produtos.json")
    private Resource produtosResource;

    public ProdutoContractResponse getProdutoV1(final Long idProduto) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(1L)
                .descricaoProduto("Produto Teste")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoContractResponse produtoContractResponse = produtoMapper.toProdutoContractResponse(produtoEntity);
        return produtoContractResponse;
    }

    public ListaProdutoContractResponse getListaProdutosV1() {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(1L)
                .descricaoProduto("Produto Teste")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return null;
    }

    @Override
    public ListaProdutoContractResponse getListaArquivoProdutosV1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ProdutoResponse>> typeReference = new TypeReference<>() {
        };
        var produtoResponseList = mapper.readValue(produtosResource.getInputStream(), typeReference);
        var listaProdutoContractResponse = produtoMapper.toListaProdutoContractResponseFromListProdutoResponse(produtoResponseList);
        return listaProdutoContractResponse;
    }

    public ProdutoResponse postProdutoV1(final ProdutoRequest produtoRequest) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(2L)
                .descricaoProduto("Produto Teste 2")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return produtoResponse;
    }

    public ProdutoResponse putProdutoV1(final Long idProduto, final ProdutoRequest produtoRequest) {
        var produtoEntity = ProdutoEntity
                .builder()
                .idProduto(2L)
                .descricaoProduto("Produto Teste 2")
                .tipoProduto(TipoProdutoEnum.NAO_DEFINIDO)
                .build();
        ProdutoResponse produtoResponse = produtoMapper.toResponse(produtoEntity);
        return produtoResponse;
    }

    public void deleteProdutoV1(final Long idProduto) {
        return;
    }
}
