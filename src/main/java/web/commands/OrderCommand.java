package web.commands;

import business.entities.BasketItem;
import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
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

        User user = (User) session.getAttribute("user");
        Basket basket = (Basket) session.getAttribute("basket");
        Order order;
        try {
            order = orderFacade.startOrder(user);
            for (BasketItem basketItem : basket.getList()) {
                cupcakeFacade.insertCupcake(order, basketItem);
            }
            session.setAttribute("order", order);
        } catch (UserException e) {
            e.printStackTrace();
        }

        return pageToShow;
    }
}
