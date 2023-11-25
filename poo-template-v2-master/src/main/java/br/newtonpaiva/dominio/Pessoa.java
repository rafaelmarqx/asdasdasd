package br.newtonpaiva.dominio;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "tbl_pessoa")

public class Pessoa extends Conta {
    @Column(name = "pessoa_id")
    private int id;
    @Column (name = "nome_pessoa")
    private String nome;
    @Column (name = "pessoa_cpf")
    private String cpf;
    @Column (name = "tel_pessoa")
    private String telefone;

    private Object CascadeType;

    //@OneToMany(mappedBy = "Conta")

    private List<Conta> contas = new LinkedList<>();

    public Pessoa(String aaa, String aaaa) {
    }


    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Pessoa(String nome, String cpf, String telefone, List<Conta> contas) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.contas = contas;
    }

    public Pessoa(){

    }

    public Pessoa(int id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id && Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, telefone);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}

