package com.igor.userapi.controller;

import com.igor.userapi.dto.EnderecoDTO;
import com.igor.userapi.dto.response.EnderecoResponseDTO;
import com.igor.userapi.entities.Endereco;
import com.igor.userapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco criarEndereco(@RequestBody EnderecoDTO dto) {
        return enderecoService.criarEndereco(dto);
    }

    @GetMapping
    public List<EnderecoResponseDTO> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }
}
