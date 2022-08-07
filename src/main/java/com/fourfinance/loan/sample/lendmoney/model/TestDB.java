package com.fourfinance.loan.sample.lendmoney.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    public static void main(String[] args) {

        String databaseURL = "jdbc:ucanaccess://c://Users//sapna.g.sharma//Documents//4Finance.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {


            String sql = "INSERT INTO IPAddressCheck (IPAddress, Count) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1.2.3.4");
            preparedStatement.setInt(2, 1);

            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("A row has been inserted successfully.");
            }

            sql = "SELECT * FROM IPAddressCheck";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("Count");
                String fullname = result.getString("IPAddress");

                System.out.println(id + ", " + fullname);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
