package com.florishop.floricultura.Service;


import com.florishop.floricultura.Repository.UsuarioRepository;
import com.florishop.floricultura.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(String nomeCompleto, String email, String senha, String username){
        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Já existe um usuário com esse e-mail!");
        }
        if (usuarioRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Já existe um usuario com esse nome!");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(nomeCompleto);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setUsername(username);

        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String email, String senha){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            if (usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}
