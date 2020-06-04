package motorhome.demo.repositories.interfaces;
// made by Mohamad Elhady

import motorhome.demo.models.Motorhome;

import java.sql.SQLException;
import java.util.List;

public interface IMotorhome
{
    //CRUD operations

    public boolean create(Motorhome motorhome) throws SQLException;

    public Motorhome read(int id);

    public List<Motorhome> readAll();

    public boolean update(Motorhome motorhome) throws SQLException;

    public boolean delete(int id);


}
