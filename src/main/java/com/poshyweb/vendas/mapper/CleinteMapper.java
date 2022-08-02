package com.poshyweb.vendas.mapper;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dto.ClienteDTO;

public class CleinteMapper {

    public static ClienteEntity toEntity(ClienteDTO dto){
        return mergeEntity(new ClienteEntity(), dto);
    }

    private static ClienteEntity mergeEntity(ClienteEntity entity, ClienteDTO dto) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setIdade(dto.getIdade());
        return entity;
    }

    public static ClienteDTO toDTO(ClienteEntity entity){
        return merge(new ClienteDTO(), entity);
    }
    private static ClienteDTO merge(ClienteDTO dto,ClienteEntity entity){
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setIdade(entity.getIdade());
        return dto;
    }
}
