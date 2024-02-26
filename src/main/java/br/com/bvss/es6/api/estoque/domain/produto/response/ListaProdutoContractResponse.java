package br.com.bvss.es6.api.estoque.domain.produto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
public class ListaProdutoContractResponse {

    private ListaProdutoContractDataResponse data;

}
