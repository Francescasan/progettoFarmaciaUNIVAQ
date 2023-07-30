package it.univaq.disim.oop.FarmaciaFc.domain;

public class Amministratore extends Utente{
    private Integer id;
    private String username;
    private String password;
    private String nome;
    private String cognome;

    public Amministratore(){
        super();
    }

    public Amministratore(int id, String username, String password, String nome, String cognome){
        super(id, username, password, nome, cognome);
    }

}
