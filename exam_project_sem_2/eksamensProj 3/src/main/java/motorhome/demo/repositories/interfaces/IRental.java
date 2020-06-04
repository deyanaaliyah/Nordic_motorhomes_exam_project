package motorhome.demo.repositories.interfaces;

//DA

import motorhome.demo.models.Rental;

import java.sql.SQLException;
import java.util.List;

public interface IRental {
    //Dette er en interface klasse, og det betyder, at når vi impementerer klassen til RentalRepositoryImpl
    //betyder dette, at den arver alle metoderne i klassen. Klassen her har ikke en body, det vil sige, at
    //det er metoder uden funktion, men det får de i RentalRepositoryImpl-klassen.

    public boolean create(Rental rental) throws SQLException;

    public Rental read(int id);

    public List<Rental> readall();

    public boolean update(Rental rental) throws SQLException;

    public boolean delete(int rental_id);
}
