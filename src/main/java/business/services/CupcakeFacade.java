package business.services;

import business.entities.Cupcake;
import business.exceptions.UserException;
import business.persistence.CupcakeMapper;
import business.persistence.Database;

import java.util.List;

public class CupcakeFacade
{
    private CupcakeMapper cupcakeMapper;

    public CupcakeFacade(Database database)

    {
        this.cupcakeMapper = new CupcakeMapper(database);
    }

    public List<Cupcake> getAllCupcakeDataEntries() throws UserException
    {
        return cupcakeMapper.getCupcakeList();
    }

    public void insertCupkageEntry(
            int topping_id,
            int bottom_id,
            int amount) throws UserException
    {
        cupcakeMapper.insertCupcake(topping_id, bottom_id, amount);
    }
}
