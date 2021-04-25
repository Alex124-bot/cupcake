package business.persistence;

import business.exceptions.UserException;
import business.services.CupcakeFacade;

import javax.servlet.ServletContext;

public class Basket {
    private CupcakeFacade cupcakeFacade;

    public Basket(CupcakeFacade cupcakeFacade) {
        this.cupcakeFacade = cupcakeFacade;
    }
}
