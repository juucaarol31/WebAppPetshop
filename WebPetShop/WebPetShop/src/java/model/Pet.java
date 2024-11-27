/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author User
 */
public class Pet {
    // Atrib
    private int id;
    private String nome;
    private String raca;
    private String nomeDono;
    private String telefone;
    private String dt_pesq;
    private int q1;
    private int q2;
    private int q3;
    private int q4;  
    
    //Métodos

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDt_pesq() {
        return dt_pesq;
    }

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }

    public int getQ3() {
        return q3;
    }

    public int getQ4() {
        return q4;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDt_pesq(String dt_pesq) {
        this.dt_pesq = dt_pesq;
    }

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public void setQ4(int q4) {
        this.q4 = q4;
    }    
}
