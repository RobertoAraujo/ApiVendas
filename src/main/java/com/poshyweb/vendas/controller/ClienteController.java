package com.poshyweb.vendas.controller;

import com.poshyweb.vendas.dominio.rapository.Cliente;
import com.poshyweb.vendas.dto.ClienteDTO;
import com.poshyweb.vendas.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private Cliente repository;

    @GetMapping(value = "/listar/todos")
    public ResponseEntity<List<com.poshyweb.vendas.dominio.entity.Cliente>> getTodosClientes() {
        try {
            List<com.poshyweb.vendas.dominio.entity.Cliente> clienteEntity = clienteService.getTodos();
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
    public ResponseEntity<Optional<com.poshyweb.vendas.dominio.entity.Cliente>> getClienteId(@PathVariable("id") Integer id) {
        try {
            Optional<com.poshyweb.vendas.dominio.entity.Cliente> clienteEntity = clienteService.buscarPorId(id);
            if (clienteEntity.isPresent()) {
                LOGGER.info("Dados Retornado com sucesso : "+ clienteEntity);
                return ResponseEntity.status(HttpStatus.OK).body(clienteEntity);
            }
        } catch (Exception e) {
            LOGGER.info("Não ha dados na base" + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<com.poshyweb.vendas.dominio.entity.Cliente> cadastrar(@Valid @RequestBody ClienteDTO dto ) {
        if (dto.getNome() != null) {
            LOGGER.info("Cadastrado com sucesso ! ", dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarDTO(dto));
        } else {
            LOGGER.info("Erro! OBS: Cadastro com nome Null !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping(value = "/update/id/{id}")
    public ResponseEntity<com.poshyweb.vendas.dominio.entity.Cliente> update(@PathVariable("id") Integer id, @RequestBody com.poshyweb.vendas.dominio.entity.Cliente cliente) {
        return clienteService.buscarPorId(id).map(clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            clienteService.salvar(cliente);
            LOGGER.info("Salvo com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/deletar/id/{id}")
    public ResponseEntity<com.poshyweb.vendas.dominio.entity.Cliente> deletar(@PathVariable("id") Integer id) {
        Optional<com.poshyweb.vendas.dominio.entity.Cliente> clienteEntity = clienteService.buscarPorId(id);
        if (clienteEntity.isPresent()) {
            clienteService.remover(clienteEntity.get().getId());
            LOGGER.info("Cleinte removido com sucesso!");
            return ResponseEntity.noContent().build();
        } else {
            LOGGER.info("Cliente não encontrado ou inexistente!");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity find( com.poshyweb.vendas.dominio.entity.Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example<com.poshyweb.vendas.dominio.entity.Cliente> example = Example.of(filtro, matcher);
        List<com.poshyweb.vendas.dominio.entity.Cliente> lista = repository.findAll(example);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
