package business.services;

import business.entities.Bottom;
import business.entities.Cupcake;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;
import java.util.List;

public class CupcakeFacade {
    private CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database) {
        this.cupcakeMapper = new CupcakeMapper(database);
    }

    public void insertCupcake(int orderId, int toppingId, int bottomId, int amount) throws UserException {
        Cupcake cupcake = new Cupcake(orderId, toppingId, bottomId, amount);
        cupcakeMapper.insertCupcake(cupcake);
    }
    public void insertCupcake(Cupcake cupcake) throws UserException {
        cupcakeMapper.insertCupcake(cupcake);
    }

    public List<Cupcake> getCupcakeList() throws UserException {
        return cupcakeMapper.getCupcakeList();
    }

    public List<Topping> getToppingList() throws UserException {
        return cupcakeMapper.getToppingList();
    }
    public List<Bottom> getBottomList() throws UserException {
        return cupcakeMapper.getBottomList();
    }

}
