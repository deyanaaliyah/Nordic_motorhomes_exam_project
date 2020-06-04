package motorhome.demo.repositories.interfaces;

import java.sql.SQLException;
import java.util.List;
import motorhome.demo.models.Employee;


public interface IEmployee
{
    // CRUD operations

    public boolean create(Employee medarbjeder) throws SQLException;

    public Employee read(int medarbejder_id) throws SQLException;

    public List<Employee> readall();

    public boolean update(Employee medarbejder) throws SQLException;

    public boolean delete(int medarbejder_id);
}
