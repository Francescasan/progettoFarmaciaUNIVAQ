package it.univaq.disim.oop.FarmaciaFc.domain;
import java.lang.String;
public class Utente {
    private Integer id;
    private String username;
    private String password;
    private String nome;
    private String cognome;

    public Utente() {
    }

    public Utente(int id, String username, String password, String nome, String cognome){
        this.id=id;
        this.username=username;
        this.password=password;
        this.nome=nome;
        this.cognome=cognome;
    }

    public Utente( String username, String password, String nome, String cognome){
        this.username=username;
        this.password=password;
        this.nome=nome;
        this.cognome=cognome;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}