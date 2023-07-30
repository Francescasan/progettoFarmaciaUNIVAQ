package it.univaq.disim.oop.FarmaciaFc.domain;


public class Contenuto{
    private Integer id;
    private Integer quantita;
    private String dosaggio;
    private Prescrizione prescrizione;
    private Farmaco farmaco;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public String getDosaggio() {
        return dosaggio;
    }

    public void setDosaggio(String dosaggio) {
        this.dosaggio = dosaggio;
    }

    public Farmaco getFarmaco(){
        return farmaco;
    }

    public void setFarmaco(Farmaco farmaco){
        this.farmaco = farmaco;
    }

    public Prescrizione getPrescrizione(){
        return prescrizione;
    }

    public void setPrescrizione(Prescrizione prescrizione){
        this.prescrizione = prescrizione;
    }
    
}
