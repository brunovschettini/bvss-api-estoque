package br.com.bvss.es6.api.estoque.api.produto.controller;

import br.com.bvss.es6.api.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;

@Tag(name = "Produtos")
@RequestMapping("/v1/produtos")
public interface ProdutoControllerV1 {

    @Operation(summary = "Consultar produto por id_produto", description = "Retorna consulta do produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrou produto",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ProdutoContractResponse.class))}),
            @ApiResponse(responseCode = "400", description = "id_produto inválido.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado.",
                    content = @Content)
    })
    @GetMapping(value = "/{idProduto}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProdutoContractResponse getProdutoV1(@PathVariable Long idProduto);

    @Operation(summary = "Lista de produtos", description = "Retorna lista de produtos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrou produtos",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ListaProdutoContractResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Problemas na consulta da lista produtos.",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Lista vazia de produtos",
                    content = @Content)
    })
    @GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
    ListaProdutoContractResponse getListaProdutosV1();

    @Operation(summary = "Lista arquivo de produtos", description = "Retorna lista de produtos contidas num arquivo json.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrou produtos no arquivo",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ListaProdutoContractResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Problemas na consulta do arquivo de lista de produtos.",
                    content = @Content),
            @ApiResponse(responseCode = "200", description = "Lista vazia de produtos no arquivo",
                    content = @Content)
    })
    @GetMapping(value = "/listaArquivoProdutos", produces = MediaType.APPLICATION_JSON_VALUE)
    ListaProdutoContractResponse getListaArquivoProdutosV1() throws IOException;

    @Operation(summary = "Inserir produto", description = "Cadastra novo produto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto inserido com sucesso.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ListaProdutoContractResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Erro ao inserir produto.",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProdutoResponse> postProdutoV1(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uriBuilder);

    @Operation(summary = "Atualiza produto", description = "Atualiza produto por id_produto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao atualizar produto.",
                    content = @Content)
    })
    @PutMapping(value = "/{idProduto}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProdutoResponse> putProdutoV1(@PathVariable Long idProduto, @RequestBody @Valid ProdutoRequest produtoRequest);

    @Operation(summary = "Deleta produto", description = "Deleta produto por id_produto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao excluir produto.",
                    content = @Content)
    })
    @DeleteMapping(value = "/{idProduto}")
    ResponseEntity deleteProdutoV1(@PathVariable Long idProduto);

}