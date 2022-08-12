package com.poshyweb.vendas.mapper;

import com.poshyweb.vendas.dominio.entity.Cliente;
import com.poshyweb.vendas.dto.ClienteDTO;

public class ClienteMapper {

    public static Cliente toEntity(ClienteDTO dto){
        return mergeEntity(new Cliente(), dto);
    }

    private static Cliente mergeEntity(Cliente entity, ClienteDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        return entity;
    }

    public static Cliente toDTO(Cliente entity){
        return mergeDTO(new ClienteDTO(), entity);
    }

    private static Cliente mergeDTO(ClienteDTO dto, Cliente entity) {
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        return entity;
    }
}
