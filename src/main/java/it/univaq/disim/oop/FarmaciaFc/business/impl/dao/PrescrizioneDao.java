package it.univaq.disim.oop.FarmaciaFc.business.impl.dao;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.*;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class PrescrizioneDao {
    private ViewDispatcher dispatcher;

    public  PrescrizioneDao(){dispatcher=ViewDispatcher.getInstance();}

    public LinkedList<Prescrizione> listaPrescrizioni() throws DatabaseException {

        Connection conn = MySqlConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM `Prescrizione`";
        LinkedList<Prescrizione> prescrizioni = new LinkedList<Prescrizione>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                int medico = rs.getInt("medico");
                int paziente = rs.getInt("paziente");
                int farmaco = rs.getInt("farmaco");
                LocalDate data = rs.getObject("dataCreazione", LocalDate.class);
                LocalTime ora = rs.getObject("oraCreazione", LocalTime.class);

                prescrizioni.add(new Prescrizione(id, medico, paziente, farmaco, data, ora));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescrizioni;
    }

    // ricerca prescrizione tramite codice
    public Prescrizione ricercaPrescrizioneID(int codice) throws DatabaseException {
        Connection connessione = MySqlConnection.getConnection();
        PreparedStatement pre;
        ResultSet ris;

    }

    // ricerca prescrizione tramite codice fiscale
    public Prescrizione ricercaPrescrizioneCF(String cf) throws DatabaseException {
        Connection connessione = MySqlConnection.getConnection();
        PreparedStatement pre;
        ResultSet ris;

    }

    public void inserimentoPrescrizione(Prescrizione pe)throws DatabaseException {
        Connection conn = MySqlConnection.getConnection();
        PreparedStatement ps;
        String query;

    }

}
