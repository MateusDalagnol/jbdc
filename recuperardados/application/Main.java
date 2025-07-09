package recuperardados.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import recuperardados.db.DB;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("Select * from department");

            while(rs.next()){
                System.out.println(rs.getInt("id") + ", " + rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
