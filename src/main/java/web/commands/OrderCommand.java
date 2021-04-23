package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.CupcakeFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCommand extends CommandUnprotectedPage {
    private OrderFacade orderFacade;
    private CupcakeFacade cupcakeFacade;
    private User user;
    private Timestamp timestamp;

    public OrderCommand(String pageToShow) {
        super(pageToShow);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int topping = 0;
        int bottom = 0;
        int amount = 0;
        int i = 0;

        try {
            topping = Integer.parseInt((request.getParameter("topping")));
            bottom = Integer.parseInt((request.getParameter("bottom")));
            amount = Integer.parseInt((request.getParameter("amount")));

        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Husk at du skal indtaste to heltal i formularen");
            return "customerpage";
        }

        request.setAttribute("topping", topping);
        request.setAttribute("bottom", bottom);
        request.setAttribute("amount", amount);

        cupcakeFacade.insertCupkageEntry(topping, bottom, amount);

//        orderFacade.insertOrderEntry(null, user.getUser_id(), timestamp, 0);

            return pageToShow;
    }
}
