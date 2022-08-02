package com.poshyweb.vendas.dominio.rapository;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import com.poshyweb.vendas.dominio.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {
    List<PedidoEntity> findByCliente(ClienteEntity cliente);
}
