package com.igor.userapi.service;


import com.igor.userapi.dto.UsuarioDTO;
import com.igor.userapi.dto.response.EnderecoResponseDTO;
import com.igor.userapi.dto.response.UsuarioResponseDTO;
import com.igor.userapi.entities.Usuario;
import com.igor.userapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Usuario criarUsuario(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public UsuarioResponseDTO converterParaDTO (Usuario usuario) {
        List<EnderecoResponseDTO> enderecosDTO = usuario.getEnderecos().stream()
                .map(endereco -> EnderecoResponseDTO.builder()
                        .id(endereco.getId())
                        .logradouro(endereco.getLogradouro())
                        .numero(endereco.getNumero())
                        .complemento(endereco.getComplemento())
                        .bairro(endereco.getBairro())
                        .cidade(endereco.getCidade())
                        .estado(endereco.getEstado())
                        .cep(endereco.getCep())
                        .build()
                )
                .toList();

        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .enderecos(enderecosDTO)
                .build();
    }
}
