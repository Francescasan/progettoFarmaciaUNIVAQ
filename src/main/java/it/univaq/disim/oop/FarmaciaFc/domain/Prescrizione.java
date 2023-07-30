package it.univaq.disim.oop.FarmaciaFc.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Prescrizione {
    private Integer id;
    private LocalDate dataCreazione;
    private LocalTime oraCreazione;
    private Evasa prescrizioneEvasa;
    private Medico medico;
    private Farmacista farmacista;
    private Farmaco farmaco;
    private Paziente paziente;

    private Set<Contenuto> FarmaciContenuti=new HashSet<>();

    public Prescrizione(int id, int medico, int paziente, LocalDate data, String evasa) {
    }

    public Prescrizione(int id, String paziente, LocalDate data, String evasa) {
    }

    public Prescrizione() {

    }

    public Prescrizione(int id, int medico, int paziente, int farmaco, LocalDate data, LocalTime ora) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCreazione( ) {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public LocalTime getOraCreazione( ) {
        return oraCreazione;
    }

    public void setOraCreazione(LocalTime oraCreazione) {
        this.oraCreazione = oraCreazione;
    }

    public Evasa getEvasa() {
        return prescrizioneEvasa;
    }

    public void setEvasa (Evasa prescrizioneEvasae) {
        this.prescrizioneEvasa= prescrizioneEvasae;
    }

    public Farmaco getFarmaco(){
        return farmaco;
    }
    
    public void setFarmaco(Farmaco farmaco){
        this.farmaco = farmaco;
    }

    public Medico getMedico(){
        return medico;
    }

    public void setMedico(Utente utente ){
        this.medico = medico;
    }

    public Farmacista getFarmacista(){
        return farmacista;
    }

    public void setFarmacista(Farmacista farmacista){
        this.farmacista = farmacista;
    }

    public String getPaziente(){
        return paziente.getCodiceFiscale();
    }

    public void setPaziente(Paziente paziente){
        this.paziente = paziente;
    }

    public void getEmissione() {
    }
}
