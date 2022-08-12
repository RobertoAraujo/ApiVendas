package com.poshyweb.vendas.dominio.rapository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cliente extends JpaRepository<com.poshyweb.vendas.dominio.entity.Cliente, Integer > {
    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<com.poshyweb.vendas.dominio.entity.Cliente> encontrarPorNome(@Param("nome") String nome );

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    com.poshyweb.vendas.dominio.entity.Cliente findClienteFetchPedidos(@Param("id") Integer id );
}
