package com.florishop.floricultura.ProdutosController;

import com.florishop.floricultura.Service.CategoriaService;
import com.florishop.floricultura.Service.ProdutosService;
import com.florishop.floricultura.models.Categoria;
import com.florishop.floricultura.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutosService produtosService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listaCategorias(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Produto> listaProdutosCategoria(@PathVariable Categoria categoria){
        return produtosService.listarProdutoPorCategoria(categoria);
    }

}
