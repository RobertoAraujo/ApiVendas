package com.poshyweb.vendas.service;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dominio.rapository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Optional<ClienteEntity> buscarPorId(Integer id){
        return repository.findById(id);
    }

    public ClienteEntity salvar(ClienteEntity entity){
//        ClienteEntity entity = ClienteMapper.toEntity(dto);
        return repository.save(entity);
    }
}
