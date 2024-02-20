package br.com.bvss.estoque.controller.produto;

import br.com.bvss.estoque.domain.produto.request.ProdutoRequest;
import br.com.bvss.estoque.domain.produto.response.ProdutoResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/produtos")
public interface ProdutoController {

    @GetMapping()
    Page<ProdutoResponse> getProdutos(final @PageableDefault(size = 10) Pageable paginacao);

    @GetMapping("/{idProduto}")
    ProdutoResponse getProduto(@PathVariable Long idProduto);

    @PostMapping()
    ResponseEntity<ProdutoResponse> postProduto(@RequestBody @Valid ProdutoRequest produtoRequest, UriComponentsBuilder uriBuilder);

    @PutMapping("/{idProduto}")
    ResponseEntity<ProdutoResponse> putProduto(@PathVariable Long idProduto, @RequestBody @Valid ProdutoRequest produtoRequest);

    @DeleteMapping("/{idProduto}")
    ResponseEntity deleteProduto(@PathVariable Long idProduto);

}
