package business.persistence;

import business.entities.Order;
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
            String sql = "SELECT * FROM `order`;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("order_id");
                    int userId = rs.getInt("user_id");
                    Date created = rs.getDate("created");

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

    public Order startOrder(int userId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order` (`user_id`) VALUES (?);";
            Order order;
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                order = new Order(rs.getInt("odre_id"), userId, rs.getDate("created"));
                return order;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
