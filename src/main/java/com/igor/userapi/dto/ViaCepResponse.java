package com.igor.userapi.dto;

import lombok.Data;

@Data
public class ViaCepResponse {
    private String logradouro;
    private String bairro;
    private String cidade; // localidade
    private String estado; // uf
}
