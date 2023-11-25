package br.newtonpaiva.dominio;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tbl_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "conta_id")
    private int id;
    @Column (name = "dt_nascimento")
    private LocalDate dataAbertura;
    @Column (name = "conta_senha")
    private String senha;
    @Column (name = "conta_saldo")
    private double saldo;

    //@ManyToOne(cascade = CascadeType.ALL)

    public Conta () {}

    public Conta(int id, LocalDate dataAbertura, String senha, double saldo) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.senha = senha; 
        this.saldo = saldo;
    }

    public Conta(String ael) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return id == conta.id && Double.compare(conta.saldo, saldo) == 0 && Objects.equals(dataAbertura, conta.dataAbertura) && Objects.equals(senha, conta.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataAbertura, senha, saldo);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", dataAbertura=" + dataAbertura +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

