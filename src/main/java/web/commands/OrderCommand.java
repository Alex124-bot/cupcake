package web.commands;

import business.persistence.Basket;
import business.services.CupcakeFacade;
import business.services.OrderFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderCommand extends CommandProtectedPage {
    public OrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        OrderFacade orderFacade = new OrderFacade(database);
        CupcakeFacade cupcakeFacade = new CupcakeFacade(database);
        Basket basket = (Basket) session.getAttribute("basket");
        return pageToShow;
    }
}
