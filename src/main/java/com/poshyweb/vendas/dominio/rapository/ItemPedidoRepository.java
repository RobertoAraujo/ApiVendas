package com.poshyweb.vendas.dominio.rapository;

import com.poshyweb.vendas.dominio.entity.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Integer> {

}
