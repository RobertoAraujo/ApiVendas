package com.poshyweb.vendas.controller;

import com.poshyweb.venda.dominio.ClienteEntity;
import com.poshyweb.venda.dto.ClienteDTO;
import com.poshyweb.venda.service.ClineteService;
import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dto.ClienteDTO;
import com.poshyweb.vendas.service.ClineteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/v1/cliente")
public class ClienteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClineteService clineteService;

    @GetMapping("listar")
    public ResponseEntity<List<ClienteEntity>> getCliente(){
        try{
            LOGGER.info("Inicio da busca aqui");
            List<ClienteEntity> clienteEntity = clineteService.getClienteEntity();
            return ResponseEntity.status(HttpStatus.OK).body(clienteEntity);
        }catch (Exception e){
            System.out.println("Nem um dado encontrado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = "inserir")
    public ResponseEntity<ClienteEntity> create(@RequestBody ClienteDTO dto) {
        if (dto != null){
            LOGGER.info("Cadastrado com sucesso!");
            ClienteEntity entity = clineteService.salvarCleinte(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(entity);
        }else{
            System.out.println("Erro ao cadastrar......");
        }
        return null;
    }

}
