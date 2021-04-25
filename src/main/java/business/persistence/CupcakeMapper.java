package business.persistence;

import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Order;
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

    public List<Cupcake> getCupcakeList() throws UserException {
        List<Cupcake> cupcakeList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM cupcake;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int cupcakeId = rs.getInt("cupcake_id");
                    int orderId = rs.getInt("order_id");
                    int toppingId = rs.getInt("topping_id");
                    int bottomId = rs.getInt("bottom_id");
                    int amount = rs.getInt("amount");

                    cupcakeList.add(new Cupcake(cupcakeId, orderId, toppingId, bottomId, amount));
                }
                return cupcakeList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    public List<Bottom> getBottomList() throws UserException {
        List<Bottom> bottomList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bottom;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bottomId = rs.getInt("bottom_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");

                    bottomList.add(new Bottom(bottomId, name, price));
                }
                return bottomList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    public List<Topping> getToppingList() throws UserException {
        List<Topping> toppingList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM topping;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int toppingId = rs.getInt("topping_id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");

                    toppingList.add(new Topping(toppingId, name, price));
                }
                return toppingList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public void insertCupcake(Cupcake cupcake) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `cupcake` (`order_id`, `topping_id`, `bottom_id`, `amount`) VALUES (?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, cupcake.getOrderId());
                ps.setInt(2, cupcake.getToppingId());
                ps.setInt(3, cupcake.getBottomId());
                ps.setInt(4, cupcake.getAmount());
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
