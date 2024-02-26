package br.com.bvss.es6.api.estoque.domain.produto.mapper;


import br.com.bvss.es6.api.estoque.domain.produto.entity.ProdutoEntity;
import br.com.bvss.es6.api.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractDataResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Mapper(imports = {Collections.class, Iterable.class}, componentModel = "spring")
public interface ProdutoMapper {

    ProdutoResponse toResponse(ProdutoEntity entity);

    @Mapping(target = "idProduto", ignore = true)
        // ignorar map
    ProdutoEntity toEntity(ProdutoRequest produtoRequest);

    @Mapping(source = "idProduto", target = "data.produto.idProduto")
    @Mapping(source = "descricaoProduto", target = "data.produto.descricaoProduto")
    @Mapping(source = "tipoProduto", target = "data.produto.tipoProduto")
    ProdutoContractResponse toProdutoContractResponse(ProdutoEntity produtoEntity);

    @Mapping(source = "idProduto", target = "idProduto")
    @Mapping(source = "descricaoProduto", target = "descricaoProduto")
    @Mapping(source = "tipoProduto", target = "tipoProduto")
    ProdutoResponse toProdutoResponse(ProdutoEntity produtoEntity);

    default List<ProdutoResponse> toListProdutoResponse(ProdutoEntity produtoEntity) {
        return produtoEntity != null ? Collections.singletonList(toProdutoResponse(produtoEntity)) :
                new ArrayList<>();
    }

    /**
     * ListaProdutoContractResponse
     */
    default ListaProdutoContractResponse toListaProdutoContractResponseFromListProdutoResponse(List<ProdutoResponse> listProdutoResponse) {
        return ListaProdutoContractResponse
                .builder()
                .data(toListaProdutoContractDataResponseFromListProdutoResponse(listProdutoResponse))
                .build();
    }

    default ListaProdutoContractDataResponse toListaProdutoContractDataResponseFromListProdutoResponse(List<ProdutoResponse> listProdutoResponse) {
        return ListaProdutoContractDataResponse
                .builder()
                .produtos(listProdutoResponse)
                .build();
    }
}
