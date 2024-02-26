package br.com.bvss.es6.api.estoque.domain.produto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Validated
@Getter
@Setter
public class ProdutoRequest {
    @NotEmpty(message = "descricao_produto nao pode ser vazia.")
    @Max(value = 100, message = "descricao_produto nao pode ser maior que 100 caracteres.")
    @JsonProperty("descricao_produto")
    private String descricaoProduto;
    @NotEmpty(message = "tipo_produto nao pode ser vazia.")
    @JsonProperty("tipo_produto")
    private String tipoProduto;
}
