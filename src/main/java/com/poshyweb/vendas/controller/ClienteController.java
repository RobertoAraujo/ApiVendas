package com.poshyweb.vendas.controller;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/listar/todos")
    public ResponseEntity<List<ClienteEntity>> getTodosClientes() {
        try {
            List<ClienteEntity> clienteEntity = clienteService.getTodos();
            if (!clienteEntity.isEmpty()) {
                LOGGER.info("Dados Retornado com sucesso");
                return ResponseEntity.status(HttpStatus.OK).body(clienteEntity);
            }
        } catch (Exception e) {
            LOGGER.info("Não ha dados na base" + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping(value = "/listar/id/{id}")
    public ResponseEntity<Optional<ClienteEntity>> getClienteId(@PathVariable("id") Integer id) {
        try {
            Optional<ClienteEntity> clienteEntity = clienteService.buscarPorId(id);
            if (clienteEntity.isPresent()) {
                LOGGER.info("Dados Retornado com sucesso");
                return ResponseEntity.status(HttpStatus.OK).body(clienteEntity);
            }
        } catch (Exception e) {
            LOGGER.info("Não ha dados na base" + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<ClienteEntity> cadastrar(@RequestBody ClienteEntity cliente) {
        LOGGER.info("Cadastrado com sucesso !");
        if (cliente.getNome() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
        } else {
            LOGGER.info("Erro! OBS: Cadastro com nome Null !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping(value = "/update/id/{id}")
    public ResponseEntity update(@PathVariable ("id") Integer id, @RequestBody ClienteEntity cliente) {
        return clienteService.buscarPorId(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteService.salvar(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.noContent().build());
    }


}
