package it.univaq.disim.oop.FarmaciaFc.domain;

import java.util.HashSet;
import java.util.Set;


public class Paziente extends Utente{
    private String codiceFiscale;
    private Set<Prescrizione>  assegnato = new HashSet<>();

    public Paziente(int id, String nome, String cognome, String username, String password, String codicefiscale) {
    }

    public Paziente() {

    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Set<Prescrizione> getAssegnato() {
        return assegnato;
    }

    public void setAssegnato(Set<Prescrizione> assegnato) {
        this.assegnato = assegnato;
    }

}
