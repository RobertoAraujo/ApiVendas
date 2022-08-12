package com.poshyweb.vendas.service;

import com.poshyweb.vendas.dominio.rapository.Cliente;
import com.poshyweb.vendas.dto.ClienteDTO;
import com.poshyweb.vendas.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private Cliente repository;

    public Optional<com.poshyweb.vendas.dominio.entity.Cliente> buscarPorId(Integer id){
        return repository.findById(id);
    }
    public List<com.poshyweb.vendas.dominio.entity.Cliente> getTodos(){
        return repository.findAll();
    }

    public com.poshyweb.vendas.dominio.entity.Cliente salvarDTO(ClienteDTO dto){
        com.poshyweb.vendas.dominio.entity.Cliente entity = ClienteMapper.toEntity(dto);
        return repository.save(entity);
    }

    public com.poshyweb.vendas.dominio.entity.Cliente salvar(com.poshyweb.vendas.dominio.entity.Cliente cliente){
        com.poshyweb.vendas.dominio.entity.Cliente dto = ClienteMapper.toDTO(cliente);
        return repository.save(dto);
    }

    public void remover(Integer id){
        repository.deleteById(id);
    }
}
