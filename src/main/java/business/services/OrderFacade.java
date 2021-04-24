package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.util.List;

public class OrderFacade
{
    private CupcakeMapper cupcakeMapper;

    public OrderFacade(Database database)

    {
        this.cupcakeMapper = new CupcakeMapper(database);
    }

    public List<Order> getOrderList() throws UserException
    {
        return cupcakeMapper.getOrderList();
    }

    public void insertOrder(
            int order_id,
            int user_id,
            int created,
            int completed) throws UserException
    {
        cupcakeMapper.insertOrder(order_id, user_id, created, completed);
    }
}
