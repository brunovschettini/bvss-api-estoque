package br.com.bvss.es6.api.estoque.domain.produto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
public class ListaProdutoContractDataResponse {

    private List<ProdutoResponse> produtos;

}
