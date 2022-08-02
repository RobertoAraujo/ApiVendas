package com.poshyweb.vendas.mapper;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dto.ClienteDTO;

public class ClienteMapper {

    public static ClienteEntity toEntity(ClienteDTO dto){
        return mergeEntity(new ClienteEntity(), dto);
    }

    private static ClienteEntity mergeEntity(ClienteEntity entity, ClienteDTO dto) {
        entity.setNome(dto.getNome());
        return entity;
    }
}
