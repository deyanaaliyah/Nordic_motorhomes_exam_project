package motorhome.demo.repositories;

import motorhome.demo.models.Motorhome;
import motorhome.demo.repositories.interfaces.IMotorhome;
import motorhome.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MotorhomeRepositoryImpl implements IMotorhome {

    private Connection connectionToMySQL;

    public MotorhomeRepositoryImpl(){
        this.connectionToMySQL = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public boolean create(Motorhome motorhome) throws SQLException {
        PreparedStatement motorhomeToInsert = connectionToMySQL.prepareStatement("INSERT INTO nordic_motorhome_rental.motorhome VALUES(?,?,?,?,?,?,?,?)");

        try{
            //Prepare a statement to execute to mySQL
            //Data placement in rows and columns
            motorhomeToInsert.setInt(1,motorhome.getMotorhomeId());
            motorhomeToInsert.setDouble(2,motorhome.getPricePerDay());
            motorhomeToInsert.setString(3, motorhome.getNumberPlate());
            motorhomeToInsert.setString(4,motorhome.getBrand());
            motorhomeToInsert.setString(5,motorhome.getModel());
            motorhomeToInsert.setInt(6,motorhome.getYear());
            motorhomeToInsert.setString(7,motorhome.getColor());
            motorhomeToInsert.setInt(8,motorhome.getBedding());
            //Execute courseToInsert + update
            motorhomeToInsert.executeUpdate();

        }catch (SQLException e) {
            //Catch SQL exception
            System.out.println(e);
        }
        return true;
    }

    @Override
    public Motorhome read(int id) {
        //New instance of class "motorhome"
        Motorhome motorhomeToReturn = new Motorhome();
        try {
            //Prepare a statement to send to mySQL database
            PreparedStatement getSingleMotorhome = connectionToMySQL.prepareStatement("SELECT * FROM nordic_motorhome_rental.motorhome WHERE motorhome_id=" + id);
            //Execute the statement
            ResultSet rs = getSingleMotorhome.executeQuery();
            while (rs.next()) {
                //...as long as rs is not empty, get Motorhome details (motorhomeId, price, etc.)
                motorhomeToReturn = new Motorhome();
                motorhomeToReturn.setMotorhomeId(rs.getInt("motorhome_id"));
                motorhomeToReturn.setPricePerDay(rs.getDouble("motorhome_price"));
                motorhomeToReturn.setNumberPlate(rs.getString("motorhome_license_plate"));
                motorhomeToReturn.setBrand(rs.getString("motorhome_brand"));
                motorhomeToReturn.setModel(rs.getString("motorhome_model"));
                motorhomeToReturn.setYear(rs.getInt("motorhome_year"));
                motorhomeToReturn.setColor(rs.getString("motorhome_colour"));
                motorhomeToReturn.setBedding(rs.getInt("motorhome_bedding"));

            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        //Return new version of the class "Motorhome"
        return motorhomeToReturn;
    }
    //Read all Motorhome details
    public List<Motorhome> readAll() {

        //Create arraylist from the class "Motorhome"
            List<Motorhome> motorhomeArraylist = new ArrayList<Motorhome>();
            try {
                //Prepare a statement to send to mySQL database
                PreparedStatement ps = connectionToMySQL.prepareStatement("SELECT * FROM nordic_motorhome_rental.motorhome");
                //Execute the statement
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    //...as long as rs is not empty, get motorhome details by method(motorhome_id, motorhome_price, etc.)
                    Motorhome getMotorhomeDetails = new Motorhome();
                    getMotorhomeDetails.setMotorhomeId(rs.getInt("motorhome_id"));
                    getMotorhomeDetails.setPricePerDay(rs.getDouble("motorhome_price"));
                    getMotorhomeDetails.setNumberPlate(rs.getString("motorhome_license_plate"));
                    getMotorhomeDetails.setBrand(rs.getString("motorhome_brand"));
                    getMotorhomeDetails.setModel(rs.getString("motorhome_model"));
                    getMotorhomeDetails.setYear(rs.getInt("motorhome_year"));
                    getMotorhomeDetails.setColor(rs.getString("motorhome_colour"));
                    getMotorhomeDetails.setBedding(rs.getInt("motorhome_bedding"));
                    //Add getMotorhomeDetails into arraylist
                    motorhomeArraylist.add(getMotorhomeDetails);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Return new version of arraylist
            return motorhomeArraylist;

    }

    @Override
    public boolean update(Motorhome motorhome) throws SQLException {

        try{

            //Prepare a statement to send to mySQL database
            PreparedStatement statement = connectionToMySQL.prepareStatement(

                    "UPDATE motorhome SET motorhome_id=?, motorhome_price = ?, motorhome_license_plate = ?," +
                            "motorhome_brand = ?, motorhome_model = ?, motorhome_year = ?, motorhome_colour = ?, motorhome_bedding = ? WHERE motorhome_id=?");

            //Change values "?" from statement to .get methods from the class "Motorhome"
            statement.setInt(1,motorhome.getMotorhomeId());
            statement.setDouble(2,motorhome.getPricePerDay());
            statement.setString(3,motorhome.getNumberPlate());
            statement.setString(4,motorhome.getBrand());
            statement.setString(5,motorhome.getModel());
            statement.setInt(6,motorhome.getYear());
            statement.setString(7,motorhome.getColor());
            statement.setInt(8,motorhome.getBedding());
            statement.setInt(9,motorhome.getMotorhomeId());
            //Execute statement + update
            statement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return true;

    }

    @Override
    public boolean delete(int motorhome_id) {
        try{
            //Prepare a statement to send to mySQL database
            PreparedStatement st = connectionToMySQL.prepareStatement("DELETE FROM motorhome WHERE motorhome_id = ?");
            //Delete value "?" from get methods from the class "Motorhome"
            st.setInt(1,motorhome_id);
            //Execute statement + update
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
