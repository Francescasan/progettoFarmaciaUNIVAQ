package it.univaq.disim.oop.FarmaciaFc.business.impl.dao;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.LinkedList;

public class FarmacoDao {
    private ViewDispatcher dispatcher;
    private int p;
    public  FarmacoDao(){dispatcher=ViewDispatcher.getInstance();}

    //Lista farmaci in esaurimento
    public LinkedList<Farmaco>esaurimentoFarmaci() throws DatabaseException{
        Connection connessione=MySqlConnection.getConnection();
        PreparedStatement pre;
        ResultSet ris;
        String query="SELECT * FROM `Farmaco` WHERE `quantitàMinima` > `disponibilita`";
        LinkedList <Farmaco>  esauriti=new LinkedList<>();
        try {
            pre= connessione.prepareStatement(query);
            ris=pre.executeQuery(query);
            while(ris.next()){
                int id=ris.getInt("id");
                int disponibilita=ris.getInt("disponibilita");
                int quantitaMinimia=ris.getInt("quantitàMinima");
                String nomeFarmaco=ris.getString("nomeFarmaco");
                String casaFarmaceutica= ris.getString("casaFarmaceutica");
                String metodoConservazione= ris.getString("metodoConservazione");
                String tipoContenuto= ris.getString("tipoContenuto");
                String tipoUso= ris.getString("tipoUso");
                String effettiIndesiderati = ris.getString("effettiIndesiderati");
                esauriti.add(new Farmaco(id, disponibilita, quantitaMinimia, nomeFarmaco, casaFarmaceutica, metodoConservazione, tipoContenuto, tipoUso, effettiIndesiderati));
            }
        }catch (SQLException e)
        {e.printStackTrace();}
    return  esauriti;
    }

    //Lista Farmaci
    public LinkedList<Farmaco>listaFarmaci() throws DatabaseException{
        Connection connessione=MySqlConnection.getConnection();
        PreparedStatement pre;
        ResultSet ris;
        String query="SELECT * FROM `Farmaco` ";
        LinkedList <Farmaco>  lista=new LinkedList<>();
        try {
            pre= connessione.prepareStatement(query);
            ris=pre.executeQuery(query);
            while(ris.next()){
                int id=ris.getInt("id");
                int disponibilita=ris.getInt("disponibilita");
                int quantitaMinimia=ris.getInt("quantitàMinima");
                String nomeFarmaco=ris.getString("nomeFarmaco");
                String casaFarmaceutica= ris.getString("casaFarmaceutica");
                String metodoConservazione= ris.getString("metodoConservazione");
                String tipoContenuto= ris.getString("tipoContenuto");
                String tipoUso= ris.getString("tipoUso");
                String effettiIndesiderati = ris.getString("effettiIndesiderati");
                lista.add(new Farmaco(id, disponibilita, quantitaMinimia, nomeFarmaco, casaFarmaceutica, metodoConservazione, tipoContenuto, tipoUso, effettiIndesiderati));
            }
        }catch (SQLException e)
        {e.printStackTrace();}
        return  lista;
    }

    //eliminazione farmaco
    public void elimina(Farmaco fa ) throws DatabaseException{
        Connection conn= MySqlConnection.getConnection();
        PreparedStatement pre;
        String query= "DELETE FROM `Farmaco` WHERE `id`=? ";
        try {
            pre=conn.prepareStatement(query);
            pre.setInt(1,fa.getId());
            pre.execute();
        }catch (SQLException e)
        { e.printStackTrace();}
    }

    //modifica farmaco
    public void modifica(Farmaco fa) throws DatabaseException {
        Connection conp = MySqlConnection.getConnection();
        PreparedStatement pre;
        String query = "UPDATE `Farmaco` SET `disponibilita` = ?, `quantitàMinima`=?, `nomeFarmaco`=?,`casaFarmaceutica`=?,`metodoConservazione`=?,`tipoContenuto`=?,`tipoUso`=?, `effettiIndesiderati`=? WHERE `id`= ?";

        try {
            pre = conp.prepareStatement(query);
            pre.setInt(1, fa.getDisponibilita());
            pre.setInt(2, fa.getQuantitaMinima());
            pre.setString(3, fa.getNomeFarmaco());
            pre.setString(4, fa.getCasaFarmaceutica());
            pre.setString(5, fa.getMetodoCoservazione());
            pre.setString(6, fa.getTipoContenuto());
            pre.setString(7, fa.getTipoUso());
            pre.setString(8, fa.getEffettiIndesiderati());
            pre.setInt(9, fa.getId());
            pre.execute();
            if(pre.executeUpdate()>0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modifica effettuata");
                alert.setHeaderText("Modifica  effettuata con successo!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserimentoFarmaco(Farmaco fa)throws DatabaseException {
        Connection conp = MySqlConnection.getConnection();
        PreparedStatement pre;
        String query = "INSERT INTO `Farmaco` (`disponibilita` , `quantitàMinima`, `nomeFarmaco`,`casaFarmaceutica`,`metodoConservazione`,`tipoContenuto`,`tipoUso`, `effettiIndesiderati`) VALUES (?,?,?,?,?,?,?,?)";

        try {
            pre = conp.prepareStatement(query);
            pre.setInt(1, fa.getDisponibilita());
            pre.setInt(2, fa.getQuantitaMinima());
            pre.setString(3, fa.getNomeFarmaco());
            pre.setString(4, fa.getCasaFarmaceutica());
            pre.setString(5, fa.getMetodoCoservazione());
            pre.setString(6, fa.getTipoContenuto());
            pre.setString(7, fa.getTipoUso());
            pre.setString(8, fa.getEffettiIndesiderati());
            pre.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inserimento  effettuato");
                alert.setHeaderText("Inserimento  effettuato con successo!");
                alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ricerca farmaco tramite l'id
    public Farmaco ricercaFarmacoID(int codice) throws DatabaseException {
        Connection connessione = MySqlConnection.getConnection();
        PreparedStatement pre;
        ResultSet ris;

        String query = "SELECT * FROM `Farmaco` WHERE `id` = ?";
        Farmaco f = new Farmaco();
        try {
            pre = connessione.prepareStatement(query);
            pre.setInt(1, codice);
            ris= pre.executeQuery();
            if(ris.next()) {
                f.setId(ris.getInt("id"));
                f.setDisponibilita(ris.getInt("disponibilita"));
                f.setQuantitaMinima(ris.getInt("quantitàMinima"));
                f.setEffettiIndesiderati(ris.getString("effettiIndesiderati"));
                f.setTipoUso(ris.getString("tipoUso"));
                f.setTipoContenuto(ris.getString("tipoContenuto"));
                f.setMetodoCoservazione(ris.getString("metodoConservazione"));
                f.setCasaFarmaceutica(ris.getString("casaFarmaceutica"));
                f.setNomeFarmaco(ris.getString("nomeFarmaco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    // ricerca farmaco tramite nome
    public Farmaco ricercaFarmacoNome(String nomeFarmaco) throws DatabaseException {
        Connection connessione = MySqlConnection.getConnection();
        PreparedStatement pre;
        ResultSet ris;

        String query = "SELECT * FROM `Farmaco` WHERE `nomeFarmaco` = ?";
        Farmaco f = new Farmaco();
        try {
            pre = connessione.prepareStatement(query);
            pre.setString(1, nomeFarmaco);
            ris= pre.executeQuery();
        if(ris.next()) {
              f.setId(ris.getInt("id"));
              f.setDisponibilita(ris.getInt("disponibilita"));
              f.setQuantitaMinima(ris.getInt("quantitàMinima"));
              f.setEffettiIndesiderati(ris.getString("effettiIndesiderati"));
              f.setTipoUso(ris.getString("tipoUso"));
              f.setTipoContenuto(ris.getString("tipoContenuto"));
              f.setMetodoCoservazione(ris.getString("metodoConservazione"));
              f.setCasaFarmaceutica(ris.getString("casaFarmaceutica"));
              f.setNomeFarmaco(ris.getString("nomeFarmaco"));
              }
        } catch (SQLException e) {
            e.printStackTrace();
        }return f;
      }

      //aggiornamento dati dopo rifornimento
      public void addQuantita( String nome, int disponibilita) throws DatabaseException {
          Connection conp = MySqlConnection.getConnection();
          PreparedStatement pre;
          String query = "UPDATE `Farmaco` SET `disponibilita` = ? WHERE `nomeFarmaco`= ?";

          try {
              pre = conp.prepareStatement(query);
              pre.setInt(1,disponibilita);
              pre.setString(2,nome);
              pre.execute();
              if(pre.executeUpdate()>0) {
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Modifica effettuata");
                  alert.setHeaderText("Modifica  effettuata con successo!");
                  alert.showAndWait();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
}
