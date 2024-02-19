package Studieadministration;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        UseCase u = new UseCase();

        Studerende s;
        s = u.soegStamOplysninger(1);

        System.out.println(s);

        /*Connection connection;
        connection = null;
        Statement stmt = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Studieadministration";
            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "SELECT * from studerende";
        try{
            stmt=connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }


            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
}
