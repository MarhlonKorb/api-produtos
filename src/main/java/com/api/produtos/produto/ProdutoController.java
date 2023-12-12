package com.api.produtos.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoServiceImpl produtoService;

    @Autowired
    public void setProdutoService(ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public Set<Produto> getAll(){
        return produtoService.getAll();
    }

    @PutMapping
    public Produto update(@RequestBody Produto produto){
        return produtoService.update(produto);
    }

    @PostMapping()
    public Produto create(@RequestBody Produto produto){
        return produtoService.create(produto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        produtoService.delete(id);
    }
}
