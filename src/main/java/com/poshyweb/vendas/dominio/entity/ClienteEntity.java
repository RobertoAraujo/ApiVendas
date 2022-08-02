package com.poshyweb.vendas.dominio.entity;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "idade")
    private int idade;
    @Column(name = "nome")
    private String nome;

//    private EnderecoEntity endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public EnderecoEntity getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(EnderecoEntity endereco) {
//        this.endereco = endereco;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity entity = (ClienteEntity) o;
        return idade == entity.idade && Objects.equals(id, entity.id) && Objects.equals(cpf, entity.cpf) && Objects.equals(nome, entity.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, idade, nome);
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                '}';
    }
}
