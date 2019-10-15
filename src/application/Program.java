package application;

import db.DB;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        if (conn != null) {
            System.out.println("Connectado!!!!!!!!!");
        }
        DB.closeConnection();
    }
}
