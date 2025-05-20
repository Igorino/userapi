package com.igor.userapi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private List<EnderecoResponseDTO> enderecos;
}
