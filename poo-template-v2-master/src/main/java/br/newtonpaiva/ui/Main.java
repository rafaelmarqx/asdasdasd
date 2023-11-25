package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Conta;
import br.newtonpaiva.dominio.Pessoa;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        var factory = Persistence.createEntityManagerFactory("conta");

        var em = factory.createEntityManager();

        Pessoa PessoA = new Pessoa("Raf", "ael");
        Conta ContA = new Conta("ael");


        em.getTransaction().begin();
        em.persist(PessoA);
        em.persist(ContA);
        em.getTransaction().commit();

        var Conta = em.find(Conta.class, 1);
        System.out.println("Conta: 1 " + Conta);

        Conta.setSenha("rafa");

        em.getTransaction().begin();
        em.merge(Conta);
        em.getTransaction().commit();

        System.out.println("Conta apos alteracao: " + Conta);

        em.getTransaction().begin();
        em.remove(Conta);
        em.getTransaction().commit();


        em.close();
        factory.close();

    }
}
