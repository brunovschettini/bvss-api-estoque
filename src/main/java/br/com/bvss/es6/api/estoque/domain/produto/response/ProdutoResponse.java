package br.com.bvss.es6.api.estoque.domain.produto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProdutoResponse {

    @JsonProperty("id_produto")
    private Long idProduto;
    @JsonProperty("descricao_produto")
    private String descricaoProduto;
    @JsonProperty("tipo_produto")
    private String tipoProduto;
}
