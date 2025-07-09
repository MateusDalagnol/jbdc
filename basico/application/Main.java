package basico.application;

import java.sql.Connection;

import basico.db.DB;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
