package com.florishop.floricultura.ProdutosController;

import com.florishop.floricultura.Service.UsuarioService;
import com.florishop.floricultura.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario (@RequestBody Usuario usuario) {
        try {
            usuarioService.registrarUsuario(
                    usuario.getNomeCompleto(),
                    usuario.getEmail(),
                    usuario.getSenha(),
                    usuario.getUsername()
            );
            Map<String, String> response = new HashMap<>();
            response.put("message", "Usuario registrado com sucesso!");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuarioRequest) {
        String email = usuarioRequest.getEmail();
        String senha = usuarioRequest.getSenha();

        Usuario usuario = usuarioService.autenticarUsuario(email, senha);

        if (usuario != null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login realizado com sucesso!");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Email ou senha incorreto!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
