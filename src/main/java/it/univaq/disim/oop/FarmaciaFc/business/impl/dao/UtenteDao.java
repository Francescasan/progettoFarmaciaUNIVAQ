package it.univaq.disim.oop.FarmaciaFc.business.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.univaq.disim.oop.FarmaciaFc.business.impl.UtenteNotFoundException;
import it.univaq.disim.oop.FarmaciaFc.domain.Medico;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmacista;
import it.univaq.disim.oop.FarmaciaFc.domain.Amministratore;
import it.univaq.disim.oop.FarmaciaFc.domain.Utente;
import it.univaq.disim.oop.FarmaciaFc.domain.Paziente;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.view.ViewDispatcher;
import javafx.scene.control.Alert;
public class UtenteDao {
    private ViewDispatcher dispatcher;

    public UtenteDao() {
        dispatcher = ViewDispatcher.getInstance();
    }

    public Utente authenticate (String username, String password) throws DatabaseException, UtenteNotFoundException {

        Connection con = MySqlConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String queryAdmin = "SELECT * FROM `Amministratore`";
        String queryFarmacista = "SELECT * FROM `Farmacista`";
        String queryMedico = "SELECT * FROM `Medico`";
        String queryPaziente = "SELECT * FROM `Paziente`";

        try {

            ps = con.prepareStatement(queryAdmin);
            rs = ps.executeQuery(queryAdmin);

            while (rs.next()) {
                if (username.equalsIgnoreCase(rs.getString("username")) &&
                        password.equals(rs.getString("password"))) {
                    Amministratore amm = new Amministratore();
                    amm.setId(rs.getInt("id"));
                    amm.setUsername(rs.getString("username"));
                    amm.setNome(rs.getString("nome"));
                    amm.setCognome(rs.getString("cognome"));
                    amm.setPassword(rs.getString("password"));
                    return amm;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = con.prepareStatement(queryFarmacista);
            rs = ps.executeQuery(queryFarmacista);

            while (rs.next()) {
                if (username.equalsIgnoreCase(rs.getString("username")) &&
                        password.equals(rs.getString("password"))) {
                    Farmacista farmacista = new Farmacista();
                    farmacista.setId(rs.getInt("id"));
                    farmacista.setUsername(rs.getString("username"));
                    farmacista.setNome(rs.getString("nome"));
                    farmacista.setCognome(rs.getString("cognome"));
                    farmacista.setPassword(rs.getString("password"));
                    return farmacista;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = con.prepareStatement(queryMedico);
            rs = ps.executeQuery(queryMedico);

            while (rs.next()) {
                if (username.equalsIgnoreCase(rs.getString("username")) &&
                        password.equals(rs.getString("password"))) {
                    Medico medico = new Medico();
                    medico.setId(rs.getInt("id"));
                    medico.setUsername(rs.getString("username"));
                    medico.setNome(rs.getString("nome"));
                    medico.setCognome(rs.getString("cognome"));
                    medico.setPassword(rs.getString("password"));
                    return medico;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = con.prepareStatement(queryPaziente);
            rs = ps.executeQuery(queryPaziente);

            while (rs.next()) {
                if (username.equalsIgnoreCase(rs.getString("username")) &&
                        password.equals(rs.getString("password"))) {
                    Paziente paziente = new Paziente();
                    paziente.setId(rs.getInt("id"));
                    paziente.setUsername(rs.getString("username"));
                    paziente.setNome(rs.getString("nome"));
                    paziente.setCognome(rs.getString("cognome"));
                    paziente.setPassword(rs.getString("password"));
                    paziente.setCodiceFiscale(rs.getString("codiceFiscale"));
                    return paziente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new UtenteNotFoundException();
    }

    public void register(Utente u) throws DatabaseException {
        Connection con = MySqlConnection.getConnection();
        PreparedStatement ps1;
        String query;

        if (u instanceof Medico) {
            query = "INSERT INTO `Medico`(`nome`, `cognome`, `username`, `password`) VALUES (?,?,?,?)";
        }
        else {
            if(u instanceof Paziente){
                query = "INSERT INTO `Paziente`(`nome`, `cognome`, `username`, `password`, `codiceFiscale`) VALUES (?,?,?,?,?)";
            }
            else{
                query = "INSERT INTO `Farmacista`(`nome`, `cognome`, `username`, `password`) VALUES (?,?,?,?)";
            }
        }

        try {
            ps1 = con.prepareStatement(query);
            ps1.setString(1, u.getNome());
            ps1.setString(2, u.getCognome());
            ps1.setString(3, u.getUsername());
            ps1.setString(4, u.getPassword());
            if (u instanceof Paziente) {
                ps1.setString(5, ((Paziente) u).getCodiceFiscale());
            }

            if (ps1.executeUpdate() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registrazione effettuata");
                alert.setHeaderText("Registrazione effettuata con successo!");
                alert.setContentText("Utente registrato!");
                alert.showAndWait();
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo per controllare se l'username è già stato utilizzato
    public boolean checkUsername(String username) throws DatabaseException {
        Connection conn = MySqlConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        boolean exists = false;
        String queryAdmin = "SELECT * FROM `Amministratore` WHERE `username` = ?";
        String queryPaziente = "SELECT * FROM `Paziente` WHERE `username` = ?";
        String queryMedico = "SELECT * FROM `Medico` WHERE `username` = ?";
        String queryFarmacista = "SELECT * FROM `Farmacista` WHERE `username` = ?";

        try {
            ps = conn.prepareStatement(queryAdmin);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = MySqlConnection.getConnection().prepareStatement(queryPaziente);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = MySqlConnection.getConnection().prepareStatement(queryFarmacista);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps = MySqlConnection.getConnection().prepareStatement(queryMedico);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
