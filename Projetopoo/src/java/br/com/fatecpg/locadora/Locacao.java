/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.locadora;

import java.sql.Date;


public class Locacao {
    
    private long id;
    private Date emprestimo;
    private Date devolucao;

    public Locacao(long id, Date emprestimo, Date devolucao) {
        this.id = id;
        this.emprestimo = emprestimo;
        this.devolucao = devolucao;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Date emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }

    
    }
    

