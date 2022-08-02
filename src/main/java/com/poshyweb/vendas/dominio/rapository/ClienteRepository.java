package com.poshyweb.vendas.dominio.rapository;

import com.poshyweb.vendas.dominio.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer > {
    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<ClienteEntity> encontrarPorNome(@Param("nome") String nome );

    @Query(" delete from ClienteEntity c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" select c from ClienteEntity c left join fetch c.pedidos where c.id = :id  ")
    ClienteEntity findClienteFetchPedidos( @Param("id") Integer id );
}
