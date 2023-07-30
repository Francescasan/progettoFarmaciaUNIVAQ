package it.univaq.disim.oop.FarmaciaFc.business.impl.dao;

import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import it.univaq.disim.oop.FarmaciaFc.domain.Contenuto;
import it.univaq.disim.oop.FarmaciaFc.domain.Farmaco;
import it.univaq.disim.oop.FarmaciaFc.domain.Prescrizione;

import java.sql.*;
import java.util.LinkedList;

public class ContenutoDao {


    public void inserimentoFarmaco(Contenuto c)throws DatabaseException {
        Connection conn = MySqlConnection.getConnection();
        PreparedStatement ps;
        String query;
        query = "INSERT INTO `Contenuto`(`quantita`, `dosaggio`, `farmaco`, `prescrizione`) VALUES (?,?,?,?)";

        try{
            ps = conn.prepareStatement(query);
            ps.setInt(1, c.getQuantita());
            ps.setString(2, c.getDosaggio());
            //farmaco e prescrizione


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    }

