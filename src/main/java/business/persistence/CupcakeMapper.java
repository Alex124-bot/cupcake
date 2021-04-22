package business.persistence;

import business.entities.Bottom;
import business.entities.CupcakeEntry;
import business.entities.OrderEntry;
import business.entities.Topping;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {

    private Database database;

    public CupcakeMapper(Database database) {
        this.database = database;
    }

    public List<CupcakeEntry> getAllCupcakes() throws UserException {
        List<CupcakeEntry> cupkageEntryList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cupkageId = rs.getInt("cupcake_id");
                    int orderId = rs.getInt("order_id");
                    int toppingId = rs.getInt("topping_id");
                    int bottomId = rs.getInt("bottom_id");
                    int amount = rs.getInt("amount");


                    cupkageEntryList.add(new CupcakeEntry(
                            cupkageId, orderId, toppingId, bottomId, amount));
                }
                return cupkageEntryList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    public List<Bottom> getAllCupcakeBottoms() throws UserException {
        List<Bottom> bottomList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bottom;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bottomId = rs.getInt("bottom_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");

                    bottomList.add(new Bottom(
                            bottomId,
                            name,
                            price));
                }
                return bottomList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    public List<Topping> getAllCupcakeToppings() throws UserException {
        List<Topping> toppingList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM topping;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int toppingId = rs.getInt("topping_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");

                    toppingList.add(new Topping(
                            toppingId,
                            name,
                            price));
                }
                return toppingList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    public List<OrderEntry> getAllOrders() throws UserException {
        List<OrderEntry> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM order;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int userId = rs.getInt("user_id");
                    int created = rs.getInt("created");
                    int completed = rs.getInt("completed");

                    orderList.add(new OrderEntry(
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

    public void insertOrderEntry(
            int order_id,
            int user_id,
            int created,
            int completed) throws UserException {
        try (Connection connection = database.connect()) {
            String sql =
                    "INSERT INTO `order`" +
                            "(" +
                            "`ordre_id`," +
                            "`user_id`," +
                            "`created`," +
                            "`completed`)" +
                            "VALUES (?,?,?,?);";

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

    public void insertCupcakeEntry(
            int topping_id,
            int bottom_id,
            int amount) throws UserException {
        try (Connection connection = database.connect()) {
            String sql =
                    "INSERT INTO `cupcake`" +
                            "(" +
                            "`topping_id`," +
                            "`bottom_id`," +
                            "`amount`)" +
                            "VALUES (?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(2, topping_id);
                ps.setInt(3, bottom_id);
                ps.setInt(4, amount);
                ps.executeUpdate();
//                ResultSet ids = ps.getGeneratedKeys();
//                ids.next();
//                int cupcakeEntryId = ids.getInt(1);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException | UserException ex) {
            throw new UserException(ex.getMessage());
        }
    }

}
