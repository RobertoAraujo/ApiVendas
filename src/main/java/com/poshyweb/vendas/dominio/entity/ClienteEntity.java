package com.poshyweb.vendas.dominio.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name = "cliente" )
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    private Set<PedidoEntity> pedidos;
    public ClienteEntity() {
    }

    public Set<PedidoEntity> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<PedidoEntity> pedidos) {
        this.pedidos = pedidos;
    }

    public ClienteEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ClienteEntity(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(pedidos, that.pedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, pedidos);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}