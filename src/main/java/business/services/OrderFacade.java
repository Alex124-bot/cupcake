package business.services;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderFacade {
    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }

    public List<Order> getOrderList() throws UserException {
        return orderMapper.getOrderList();
    }

    public Order startOrder(User user) throws UserException {
        ResultSet metadata = orderMapper.startOrder(user.getId());
        try {
            return new Order(metadata.getInt("ordre_id"), user.getId(), metadata.getInt("created"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
