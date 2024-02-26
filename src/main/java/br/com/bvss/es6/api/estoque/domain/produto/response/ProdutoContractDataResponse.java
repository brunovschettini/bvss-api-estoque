package br.com.bvss.es6.api.estoque.domain.produto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProdutoContractDataResponse {

    private ProdutoResponse produto;

}
