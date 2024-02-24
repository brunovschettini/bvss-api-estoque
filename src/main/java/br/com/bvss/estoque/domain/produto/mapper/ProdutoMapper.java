package br.com.bvss.estoque.domain.produto.mapper;


import br.com.bvss.estoque.domain.produto.entity.ProdutoEntity;
import br.com.bvss.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.estoque.domain.produto.response.ProdutoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoResponse toResponse(ProdutoEntity entity);

    @Mapping(target = "idProduto", ignore = true) // ignorar map
    ProdutoEntity toEntity(ProdutoRequest produtoRequest);
}
