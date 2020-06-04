package motorhome.demo.repositories;

//DA

import motorhome.demo.models.Rental;
import motorhome.demo.repositories.interfaces.IRental;
import motorhome.demo.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Denne klasse implementerer metoder fra interfacet IUdlejning
public class RentalRepositoryImpl implements IRental {
    //her opretter man en private connection til vores MySQL db. Se klassen DatabaseConnectionManager for mere info
    private Connection conn;
    public RentalRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    //Create udlejning via parameter
    @Override
    public boolean create(Rental rental) throws SQLException {
        PreparedStatement rentalToAdd = conn.prepareStatement("INSERT INTO nordic_motorhome_rental.rental VALUES (?,?,?,?,?,?,?,?,?,?)");

        try {
            rentalToAdd.setInt(1, rental.getRental_id());
            rentalToAdd.setInt(2, rental.getCustomer_id());
            rentalToAdd.setInt(3, rental.getMotorhome_id());
            rentalToAdd.setInt(4, rental.getEmployee_id());
            rentalToAdd.setString(5, rental.getDate_start());
            rentalToAdd.setString(6, rental.getDate_start());
            rentalToAdd.setString(7, rental.getTotal());
            rentalToAdd.setString(8, rental.getValuta());
            rentalToAdd.setBoolean(9, rental.isPaid());
            rentalToAdd.setString(10,rental.getComments());

            rentalToAdd.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //Læs detaljer om en specifik udlejning vha dens rental_id nummer
    @Override
    public Rental read(int id) {
        Rental rentalToReturn = new Rental();

        try {
            PreparedStatement getSingleUdlejning = conn.prepareStatement("SELECT * FROM nordic_motorhome_rental.rental WHERE rental_id = " + id);

            ResultSet rs = getSingleUdlejning.executeQuery();

            while (rs.next()) {
                rentalToReturn = new Rental();

                rentalToReturn.setRental_id(rs.getInt(1));
                rentalToReturn.setCustomer_id(rs.getInt(2));
                rentalToReturn.setMotorhome_id(rs.getInt(3));
                rentalToReturn.setEmployee_id(rs.getInt(4));
                rentalToReturn.setDate_start(rs.getString(5));
                rentalToReturn.setDate_end(rs.getString(6));
                rentalToReturn.setTotal(rs.getString(7));
                rentalToReturn.setValuta(rs.getString(8));
                rentalToReturn.setPaid(rs.getBoolean(9));
                rentalToReturn.setComments(rs.getString(10));
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return rentalToReturn;
    }

    //Læs alle udlejninger
    @Override
    public List<Rental> readall() {
        List<Rental> rentalInArraylist = new ArrayList<Rental>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM nordic_motorhome_rental.rental");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rental rentals = new Rental();
                rentals.setRental_id(rs.getInt(1));
                rentals.setCustomer_id(rs.getInt(2));
                rentals.setMotorhome_id(rs.getInt(3));
                rentals.setEmployee_id(rs.getInt(4));
                rentals.setDate_start(rs.getString(5));
                rentals.setDate_end(rs.getString(6));
                rentals.setTotal(rs.getString(7));
                rentals.setValuta(rs.getString(8));
                rentals.setPaid(rs.getBoolean(9));
                rentals.setComments(rs.getString(10));

                rentalInArraylist.add(rentals);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalInArraylist;
    }

    //Opdater en udlejning vha parameteret
    @Override
    public boolean update(Rental rental) throws SQLException {

        PreparedStatement rentalToBeUpdated = conn.prepareStatement
                ("UPDATE rental SET customer_id = ?, motorhome_id = ?, employee_id = ?, date_start=?, date_end=?, total=?, valuta = ?, paid = ?, comments = ? WHERE (rental_id = ?);");
        try{
            rentalToBeUpdated.setInt(1,rental.getCustomer_id());
            rentalToBeUpdated.setInt(2,rental.getMotorhome_id());
            rentalToBeUpdated.setInt(3,rental.getEmployee_id());
            rentalToBeUpdated.setString(4,rental.getDate_start());
            rentalToBeUpdated.setString(5,rental.getDate_end());
            rentalToBeUpdated.setString(6,rental.getTotal());
            rentalToBeUpdated.setString(7,rental.getValuta());
            rentalToBeUpdated.setBoolean(8,rental.isPaid());
            rentalToBeUpdated.setString(9,rental.getComments());
            rentalToBeUpdated.setInt(10,rental.getRental_id());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(int udlejnings_id) {
        try {
            PreparedStatement rentalToDelete = conn.prepareStatement("DELETE FROM nordic_motorhome_rental.rental WHERE rental_id = ?");

            rentalToDelete.setInt(1, udlejnings_id);

            rentalToDelete.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}