package com.poshyweb.vendas.mapper;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dto.ClienteDTO;

public class ClienteMapper {

    public static ClienteEntity toEntity(ClienteDTO dto){
        return mergeEntity(new ClienteEntity(), dto);
    }

    private static ClienteEntity mergeEntity(ClienteEntity entity, ClienteDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        return entity;
    }

    public static ClienteEntity toDTO(ClienteEntity entity){
        return mergeDTO(new ClienteDTO(), entity);
    }

    private static ClienteEntity mergeDTO(ClienteDTO dto, ClienteEntity entity) {
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        return entity;
    }
}
