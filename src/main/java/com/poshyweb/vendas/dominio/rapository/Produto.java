package com.poshyweb.vendas.dominio.rapository;

import com.poshyweb.vendas.dominio.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Produto extends JpaRepository<Pedido, Integer> {
}
