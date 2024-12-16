package com.florishop.floricultura.Service;

import com.florishop.floricultura.Repository.CategoriaRepository;
import com.florishop.floricultura.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
