package web.commands;

import business.entities.BasketItem;
import business.exceptions.UserException;
import business.persistence.Basket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.StringTokenizer;

public class CustomerPage extends CommandProtectedPage {

    public CustomerPage(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Basket basket = (session.getAttribute("basket") == null) ? new Basket() : (Basket) session.getAttribute("basket");
        if (request.getParameter("clear") != null) {
            session.setAttribute("basket", null);
        }
        else if (request.getParameter("plus") != null) {
            StringTokenizer st = new StringTokenizer(request.getParameter("plus"), "%");
            basket.add(new BasketItem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1));
        } else if (request.getParameter("minus") != null) {
            StringTokenizer st = new StringTokenizer(request.getParameter("minus"), "%");
            basket.subtract(new BasketItem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1));
        } else if (request.getParameter("delete") != null) {
            StringTokenizer st = new StringTokenizer(request.getParameter("delete"), "%");
            basket.remove(new BasketItem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1));
        } else if (request.getParameter("add") != null) {
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
            } else try {
                throw new UserException("Det lykkedes ikke at tilføje cupcake til kurven.");
            } catch (UserException e) {
                e.printStackTrace();
            }
        }
        session.setAttribute("basket", basket);
        return pageToShow;
    }
}
