package application;

import db.DB;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Program3 {
    public static void main(String[] args) {
        //inserting datas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            /*
            st = conn.prepareStatement("INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, "Davi Silva");
            st.setString(2, "dssilvap@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("03/11/1985").getTime()));
            st.setDouble(4, 2500.00);
            st.setInt(5, 4);
            */

            st = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES ('D1'),('D2')",
                    Statement.RETURN_GENERATED_KEYS
            );
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done Id = " + id);
                }
            } else {
                System.out.println("No rows affected!");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
