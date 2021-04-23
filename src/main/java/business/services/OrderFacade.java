package business.services;

import business.entities.OrderEntry;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.sql.Timestamp;
import java.util.List;

public class OrderFacade
{
    private CupcakeMapper cupcakeMapper;

    public OrderFacade(Database database)

    {
        this.cupcakeMapper = new CupcakeMapper(database);
    }

    public List<OrderEntry> getAllOrderDataEntries() throws UserException
    {
        return cupcakeMapper.getAllOrders();
    }

    public void insertOrderEntry(
            Integer order_id,
            int user_id,
            int created,
            int completed) throws UserException
    {
        cupcakeMapper.insertOrderEntry(order_id, user_id, created, completed);
    }
}
