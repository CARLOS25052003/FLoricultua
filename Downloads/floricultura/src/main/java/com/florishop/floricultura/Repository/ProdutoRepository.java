package com.florishop.floricultura.Repository;

import com.florishop.floricultura.models.Categoria;
import com.florishop.floricultura.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(Categoria categoriaId);

}
