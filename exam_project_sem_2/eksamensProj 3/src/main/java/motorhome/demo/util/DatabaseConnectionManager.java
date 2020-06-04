package motorhome.demo.util;

//DA

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String user;
    private static String password;
    private static String url;
    private static Connection conn;

    public static Connection getDatabaseConnection() {
        //Hvis der er forbindelse, så fortsæt med at oprette en property fil der loader vores db-username, password og url
        if (conn != null);
        Properties prop = new Properties();

        try {
            //I så fald, hent data fra application.properties
            FileInputStream propFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(propFile);
            //Denne "user" er lig med denne "user" ...
            user = prop.getProperty("db.user");
            password = prop.getProperty("db.password");
            url = prop.getProperty("db.url");
        }

        //Fang fejlhåndtering
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Filen kunne ikke findes");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Property kunne ikke loades");
        }

        //Når det hele fungerer, så slår den hul igen
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Kunne ikke oprette forbindelse til db");
            e.printStackTrace();
        }

        //Og retunere de endelige dataer
        return conn;
    }
    }
