package it.univaq.disim.oop.FarmaciaFc.domain;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.util.HashSet;
import java.util.Set;



public class Farmaco {
    private Integer id;
    private Integer quantitaMinima;
    private String nomeFarmaco;
    private String metodoCoservazione;
    private String tipoUso;
    private String tipoContenuto;
    private String effettiIndesiderati;
    private String casaFarmaceutica;
    private Integer disponibilita;

    private Set<Prescrizione> contenuto = new HashSet<>();

    public Farmaco(Integer id, Integer disponibilita, Integer quantitaMinimia, String nomeFarmaco, String casaFarmaceutica, String metodoConservazione, String tipoContenuto, String tipoUso, String effettiIndesiderati) {
    this.id=id;
    this.disponibilita=disponibilita;
    this.quantitaMinima=quantitaMinimia;
    this.nomeFarmaco=nomeFarmaco;
    this.casaFarmaceutica=casaFarmaceutica;
    this.metodoCoservazione=metodoConservazione;
    this.tipoContenuto=tipoContenuto;
    this.tipoUso=tipoUso;
    this.effettiIndesiderati=effettiIndesiderati;
    }

    public Farmaco( Integer disponibilita, Integer quantitaMinimia, String nomeFarmaco, String casaFarmaceutica, String metodoConservazione, String tipoContenuto, String tipoUso, String effettiIndesiderati) {
        this.disponibilita=disponibilita;
        this.quantitaMinima=quantitaMinimia;
        this.nomeFarmaco=nomeFarmaco;
        this.casaFarmaceutica=casaFarmaceutica;
        this.metodoCoservazione=metodoConservazione;
        this.tipoContenuto=tipoContenuto;
        this.tipoUso=tipoUso;
        this.effettiIndesiderati=effettiIndesiderati;
    }

    public Farmaco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita (Integer disponibilita) {
        this.disponibilita= disponibilita;
    }

    public String getNomeFarmaco() {
        return nomeFarmaco;
    }

    public void setNomeFarmaco(String nomeFarmaco) {
        this.nomeFarmaco = nomeFarmaco;
    }

    public String getCasaFarmaceutica() {
        return casaFarmaceutica;
    }

    public void setCasaFarmaceutica(String casaFarmaceutica) {
        this.casaFarmaceutica = casaFarmaceutica;
    }

    public String getMetodoCoservazione() {
        return metodoCoservazione;
    }

    public void setMetodoCoservazione(String metodoCoservazione) {
        this.metodoCoservazione = metodoCoservazione;
    }

    public String getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(String tipoUso) {
        this.tipoUso = tipoUso;
    }

    public String getTipoContenuto() {
        return tipoContenuto;
    }

    public void setTipoContenuto(String tipoContenuto) {
        this.tipoContenuto = tipoContenuto;
    }

    public String getEffettiIndesiderati() {
        return effettiIndesiderati;
    }

    public void setEffettiIndesiderati(String effettiIndesiderati) {
        this.effettiIndesiderati = effettiIndesiderati;
    }
    
    public Integer getQuantitaMinima() {
        return quantitaMinima;
    }

    public void setQuantitaMinima(Integer quantitaMinima) {
        this.quantitaMinima = quantitaMinima;
    }

    public Set<Prescrizione> getContenuto() {
        return contenuto;
    }

    public void put(Integer id, Farmaco farmaco) {
    }
}
