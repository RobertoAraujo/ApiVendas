package com.poshyweb.vendas.service;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dominio.rapository.ClienteRepository;
import com.poshyweb.vendas.dto.ClienteDTO;
import com.poshyweb.vendas.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Optional<ClienteEntity> buscarPorId(Integer id){
        return repository.findById(id);
    }
    public List<ClienteEntity> getTodos(){
        return repository.findAll();
    }

    public ClienteEntity salvarDTO(ClienteDTO dto){
        ClienteEntity entity = ClienteMapper.toEntity(dto);
        return repository.save(entity);
    }

    public ClienteEntity salvar(ClienteEntity cliente){
        ClienteEntity dto = ClienteMapper.toDTO(cliente);
        return repository.save(dto);
    }

    public void remover(Integer id){
        repository.deleteById(id);
    }
}
