package com.poshyweb.vendas.dominio.rapository;

import com.poshyweb.vendas.dominio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedido extends JpaRepository<com.poshyweb.vendas.dominio.entity.Pedido, Integer> {
    List<com.poshyweb.vendas.dominio.entity.Pedido> findByCliente(Cliente cliente);
}
