package com.poshyweb.vendas.dominio.rapository;

import com.poshyweb.vendas.dominio.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<PedidoEntity, Integer> {
}
