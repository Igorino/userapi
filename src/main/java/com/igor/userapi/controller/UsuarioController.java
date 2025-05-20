package com.igor.userapi.controller;

import com.igor.userapi.dto.UsuarioDTO;
import com.igor.userapi.dto.response.UsuarioResponseDTO;
import com.igor.userapi.entities.Usuario;
import com.igor.userapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criarUsuario(@RequestBody UsuarioDTO dto) {
        return usuarioService.criarUsuario(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listUsuarios() {
        return usuarioService.listarUsuarios();
    }

}
