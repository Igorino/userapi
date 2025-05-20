package com.igor.userapi.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String cep;
    private String numero;
    private String complemento;
    private Long usuarioId;
}
