package business.services;

import business.entities.CupcakeEntry;
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

    public List<CupcakeEntry> getAllCupcakeDataEntries() throws UserException
    {
        return cupcakeMapper.getAllCupcakes();
    }

    public void insertCupkageEntry(
            int topping_id,
            int bottom_id,
            int amount) throws UserException
    {
        cupcakeMapper.insertCupcakeEntry(topping_id, bottom_id, amount);
    }
}
