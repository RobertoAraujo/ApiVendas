package com.poshyweb.vendas.dominio.rapository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedido extends JpaRepository<com.poshyweb.vendas.dominio.entity.ItemPedido, Integer> {

}
