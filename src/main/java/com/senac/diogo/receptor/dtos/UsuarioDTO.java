package com.senac.diogo.receptor.dtos;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioDTO implements Serializable {
	
	@Serial
    private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private int id;
	
	@Column(name = "usuario_nome", nullable = false)
    private String nome;
	
	@Column(name = "usuario_sobrenome", nullable = false)
    private String sobrenome;
//    private String email;
	
	@Column(name = "usuario_telefone", nullable = false)
    private String telefone;
//    private int status;
    
    // Default constructor
    public UsuarioDTO() {
    }

    // Parameterized constructor
    public UsuarioDTO(int id, String nome, String sobrenome, String email, String telefone, int status) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
//        this.email = email;
        this.telefone = telefone;
//        this.status = status;
    }

    // Getters and Setters
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
}
