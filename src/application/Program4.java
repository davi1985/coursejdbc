package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {
    public static void main(String[] args) {
        //updating datas
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffects = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffects);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
