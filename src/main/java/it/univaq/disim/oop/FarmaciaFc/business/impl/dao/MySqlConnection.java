package it.univaq.disim.oop.FarmaciaFc.business.impl.dao;
import it.univaq.disim.oop.FarmaciaFc.business.impl.dao.exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class MySqlConnection {

        //private static String URL = "jdbc:mysql://localhost:8889/farmacia"; // francesca
        private static String URL = "jdbc:mysql://localhost:3306/farmacia"; // chiara

        public static Connection getConnection() throws DatabaseException {

            Connection conn = null;

            try {
                //conn = DriverManager.getConnection(URL, "root", "root"); //francesca
                conn = DriverManager.getConnection(URL, "root", null); //chiara
            } catch (SQLException e)  {
                // logger ...
                throw new DatabaseException(e.getMessage());
            }
            return conn;
        }

        public static void closeConnection(Connection conn, Statement ps, ResultSet rs) throws DatabaseException {

            try  {
                if (rs != null)  {  rs.close(); }
                if (ps != null)  { ps.close(); }
                if (conn != null)  { conn.close(); }
            } catch (SQLException e)  {
                //logger.debug(se.getMessage(),  se);
                throw new DatabaseException(e.toString());
            }
        }
}
