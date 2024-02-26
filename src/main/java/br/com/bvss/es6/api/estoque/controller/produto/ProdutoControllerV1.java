package br.com.bvss.es6.api.estoque.controller.produto;

import br.com.bvss.es6.api.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.es6.api.estoque.domain.produto.response.ListaProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoContractResponse;
import br.com.bvss.es6.api.estoque.domain.produto.response.ProdutoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/v1/produtos")
public interface ProdutoControllerV1 {

    @GetMapping("/{idProduto}")
    ProdutoContractResponse getProdutoV1(@PathVariable Long idProduto);

    @GetMapping("/lista")
    ListaProdutoContractResponse getListaProdutosV1();

    @GetMapping("/listaArquivoProdutos")
    ListaProdutoContractResponse getListaArquivoProdutosV1() throws IOException;

    @PostMapping()
    ResponseEntity<ProdutoResponse> postProdutoV1(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uriBuilder);

    @PutMapping("/{idProduto}")
    ResponseEntity<ProdutoResponse> putProdutoV1(@PathVariable Long idProduto, @RequestBody @Valid ProdutoRequest produtoRequest);

    @DeleteMapping("/{idProduto}")
    ResponseEntity deleteProdutoV1(@PathVariable Long idProduto);

}
