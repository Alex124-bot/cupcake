package web.commands;

import business.entities.BasketItem;
import business.persistence.Basket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CustomerPage extends CommandProtectedPage {

    public CustomerPage(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Basket basket;
        if (session.getAttribute("basket") == null) basket = new Basket();
        else basket = (Basket) session.getAttribute("basket");

        if (request.getParameter("topping") != null) {
            BasketItem newItem = new BasketItem();
            try {
                newItem.setToppingId(Integer.parseInt(request.getParameter("topping")));
                newItem.setBottomId(Integer.parseInt(request.getParameter("bottom")));
                newItem.setAmount(Integer.parseInt(request.getParameter("amount")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (newItem.isValid()) {
                basket.add(newItem);
                session.setAttribute("basket", basket);
            }
        }
        return pageToShow;
    }
}
