package business.persistence;

import business.entities.Order;
import business.entities.User;
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
                    int id = rs.getInt("order_id");
                    int userId = rs.getInt("user_id");
                    int created = rs.getInt("created");

                    orderList.add(new Order(id, userId, created));
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

    public void insertOrder(int customerId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order` (`user_id`) VALUES (?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, customerId);
                ps.executeUpdate();
                ResultSet metadata = ps.getGeneratedKeys();
                //metadata.next();
                //int cupcakeEntryId = metadata.getInt(1);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
