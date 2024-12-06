package com.senac.diogo.receptor.entities;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id", nullable = false)
    private int id;

    @Column(name = "materia", nullable = false)
    private String materia;

    @Column(name = "modulo", nullable = false)
    private String modulo;

    @Column(name = "nomecurso", nullable = false)
    private String nomecurso;

    @Column(name = "duracao", nullable = false)
    private int duracao;

    @Column(name = "status", nullable = false)
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Curso(String materia, String modulo, String nomecurso) {
        this.materia = materia;
        this.modulo = modulo;
        this.nomecurso = nomecurso;
        this.status = status;
        this.duracao = duracao;

    }
    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getModulo() {
        return modulo;
    }


    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }



}
