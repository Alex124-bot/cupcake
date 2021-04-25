package business.persistence;

import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Order;
import business.entities.Topping;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public List<Order> getOrderList() throws UserException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM order;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int userId = rs.getInt("user_id");
                    int created = rs.getInt("created");
                    int completed = rs.getInt("completed");

                    orderList.add(new Order(
                            orderId,
                            userId,
                            created,
                            completed));
                }
                return orderList;

            } catch (SQLException ex) {
                throw new UserException("Connection to database could not be established");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public void insertOrder(int order_id, int user_id, int created, int completed) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order` (`ordre_id`, `user_id`, `created`, `completed`) VALUES (?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order_id);
                ps.setInt(2, user_id);
                ps.setInt(3, created);
                ps.setInt(4, completed);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int cupcakeEntryId = ids.getInt(1);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
