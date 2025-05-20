package com.igor.userapi.service;

import com.igor.userapi.dto.EnderecoDTO;
import com.igor.userapi.dto.ViaCepResponse;
import com.igor.userapi.dto.response.EnderecoResponseDTO;
import com.igor.userapi.entities.Endereco;
import com.igor.userapi.entities.Usuario;
import com.igor.userapi.repository.EnderecoRepository;
import com.igor.userapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Endereco criarEndereco(EnderecoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        ViaCepResponse cepResponse = viaCepService.buscarEnderecoPorCep(dto.getCep());

        Endereco endereco = Endereco.builder()
                .cep(dto.getCep())
                .logradouro(cepResponse.getLogradouro())
                .bairro(cepResponse.getBairro())
                .cidade(cepResponse.getCidade())
                .estado(cepResponse.getEstado())
                .numero(dto.getNumero())
                .complemento(dto.getComplemento())
                .usuario(usuario)
                .build();

        return enderecoRepository.save(endereco);
    }

    public List<EnderecoResponseDTO> listarEnderecos() {
        return enderecoRepository.findAll().stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public EnderecoResponseDTO converterParaDTO(Endereco endereco) {
        return EnderecoResponseDTO.builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }
}
