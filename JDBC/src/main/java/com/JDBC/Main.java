package com.JDBC;

import java.sql.*;

public class Main {
    /*
        Import Package
        Load and Register
        Create Connection
        Create Statement
        Processes and Results
        Close
    */
    private static final String url = "jdbc:postgresql://localhost:5432/sourav";
    private static final String user = "postgres";
    private static final String password = "root";
    private static final String driver = "org.postgresql.Driver";
    private static String query;


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(driver);  // Optional
        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();

        createData(con, stmt);
        updateData(stmt);
        viewAllRows(stmt);
        deleteData(stmt);

        con.close();
    }

    private static void viewAllRows(Statement stmt) throws SQLException {
        query = "select * from student order by id";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            System.out.println("ID = " + rs.getInt(1) + ", Name = " + rs.getString("name") + ", Course taken = " + rs.getString(3) + ", Standard = " + rs.getInt("Standard"));
        }
    }

    public static void createData(Connection con, Statement stmt) throws SQLException {
        int id = 3;
        String name = "Tinni";
        String course = "Nursing";
        int standard = 4;
//        query = "insert into student values (" + id + ", '" + name + "', '" + course + "', " + standard + ")";
        query = "insert into student values (?, ?, ?, ?)";  // PreparedStatement will hash this statement into DB
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);   // PreparedStatement will retrieve the earlier hashed query from DB and sets the value into it.
        st.setString(2, name);
        st.setString(3, course);
        st.setInt(4, standard);
        System.out.println(query);
//        stmt.executeUpdate();
        st.execute();
    }

    public static void updateData(Statement stmt) throws SQLException {
        query = "update student set course='IT' where id=5";
        stmt.executeUpdate(query);
    }

    public static void deleteData(Statement stmt) throws SQLException {
        query = "delete from student where id='3'";
        stmt.executeUpdate(query);
    }
}