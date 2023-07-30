package it.univaq.disim.oop.FarmaciaFc.domain;

import java.util.HashSet;
import java.util.Set;

public class Medico extends Utente {
    private Set<Prescrizione> interazione = new HashSet<>();

    public Set<Prescrizione> getInterazione() {
        return interazione;
    }

    public void setInterazione(Set<Prescrizione> interazione) {
        this.interazione = interazione;
    }

}
