package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program3 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO seller "
                    + "(Name, Email, BirthDate,BaseSalary, DepartmentId) "
                    + "VALUES (?,?,?,?,?)"
            );

            st.setString(1, "Davi Silva");
            st.setString(2, "dssilvap@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("03/11/1985").getTime()));
            st.setDouble(4, 2500.00);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
