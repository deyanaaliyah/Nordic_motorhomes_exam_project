package motorhome.demo.repositories;

import motorhome.demo.models.Login;
import motorhome.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  LoginRepositoryImpl {

    private Connection connectionToMySQL;

    public LoginRepositoryImpl(){
        this.connectionToMySQL = DatabaseConnectionManager.getDatabaseConnection();
    }

    public Login read(String username) {
        //New instance of class "Login"
        Login loginToReturn = new Login();
        try {
            //Prepare a statement to send to mySQL database
            PreparedStatement getSingleLogin = connectionToMySQL.prepareStatement("SELECT * FROM nordic_motorhome_rental.login WHERE username = " + username);

            //Execute the statement
            ResultSet rs = getSingleLogin.executeQuery();

            while (rs.next()) {
                //...as long as rs is not empty, get Motorhome details (motorhomeId, price, etc.)
                loginToReturn = new Login();
                loginToReturn.setUsername(rs.getString("username"));
                loginToReturn.setUserPassword(rs.getString("userPassword"));
            }
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
        //Return new version of the class "Login"
        return loginToReturn;
    }
}