package com.florishop.floricultura.ProdutosController;

import com.florishop.floricultura.Service.UsuarioService;
import com.florishop.floricultura.models.Usuario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
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

    @PostMapping("/esqueceu-senha")
    public ResponseEntity<?> esqueceuSenha(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        if (!usuarioService.verificarEmail(email)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Email não encontrado!"));
        }


        String token = usuarioService.gerarTokenDeRedefinicao(email);
        usuarioService.enviarEmailRedefinicao(email, token);

        return ResponseEntity.ok(Map.of("message", "Link de redefinição enviado para o Email"));
    }

    @GetMapping("/test-email")
    public ResponseEntity<String> testEmail() {
        try {
            usuarioService.enviarEmailRedefinicao("carloscharles017@outlook.com", "teste_token");
            return ResponseEntity.ok("E-mail enviado com sucesso!");
        } catch (Exception e) {
            // Logando o erro completo para facilitar o diagnóstico
            e.printStackTrace();  // Log da pilha de exceções

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao enviar o e-mail: " + e.getMessage());
        }
    }


}
