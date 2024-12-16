package com.florishop.floricultura.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double precoOriginal;
    private Double precoDesconto;
    private String desconto;
    private String imagem;
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
