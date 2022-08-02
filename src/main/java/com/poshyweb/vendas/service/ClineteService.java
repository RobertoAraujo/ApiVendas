package com.poshyweb.vendas.service;

import com.poshyweb.venda.dominio.ClienteEntity;
import com.poshyweb.venda.dto.ClienteDTO;
import com.poshyweb.venda.mapper.CleinteMapper;
import com.poshyweb.venda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClineteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> getClienteEntity() {
        return clienteRepository.findAll();
    }

    public ClienteEntity salvarCleinte(ClienteDTO dto){
        ClienteEntity entity = CleinteMapper.toEntity(dto);
        return clienteRepository.save(entity);
    }

}
