package trancacaodados.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import deletardados.db.DbException;
import trancacaodados.db.DB;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();


            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /*int x = 1;
            if(x < 2){
                throw new SQLException("Fake error");
            } */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transation rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Erro trying to rollback! Caused by " + e.getMessage());
            }
        }
        finally{

            DB.closeStatement(st);
            DB.closeConnection();
            
        }
        
    }
}
