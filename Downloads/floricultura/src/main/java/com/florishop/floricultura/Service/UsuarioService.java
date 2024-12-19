package com.florishop.floricultura.Service;


import com.florishop.floricultura.Repository.UsuarioRepository;
import com.florishop.floricultura.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JavaMailSender javaMailSender;



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

    public boolean verificarEmail(String email){
        return usuarioRepository.findByEmail(email).isPresent();
    }

    public String gerarTokenDeRedefinicao(String email){
        String token = UUID.randomUUID().toString();
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário com o e-mail fornecido não encontrado!"));
        usuario.setResetToken(token);
        usuarioRepository.save(usuario);
        return token;
    }

    public void enviarEmailRedefinicao(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Redefinição de Senha");
        message.setText("Clique no link abaixo para redefinir sua senha:\n" +
                "http://localhost:8080/redefinir-senha?token=" + token);
        javaMailSender.send(message);
    }

}
