package com.florishop.floricultura.Service;

import com.florishop.floricultura.Repository.ProdutoRepository;
import com.florishop.floricultura.models.Categoria;
import com.florishop.floricultura.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
    public List<Produto> listarProdutoPorCategoria(Categoria categoria){
        return produtoRepository.findByCategoria(categoria);
    }
    }
