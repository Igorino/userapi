package com.igor.userapi.service;

import com.igor.userapi.dto.ViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    public ViaCepResponse buscarEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return restTemplate.getForObject(url, ViaCepResponse.class);
    }
}
