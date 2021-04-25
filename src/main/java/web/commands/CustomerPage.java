package web.commands;

import business.entities.BasketItem;

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
        if (request.getParameter("topping") != null) {
            ArrayList<BasketItem> basket;
            BasketItem newItem = new BasketItem(-1, -1, -1);
            try {
                newItem.setToppingId(Integer.parseInt(request.getParameter("topping")));
                newItem.setBottomId(Integer.parseInt(request.getParameter("bottom")));
                newItem.setAmount(Integer.parseInt(request.getParameter("amount")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (session.getAttribute("basket") == null) basket = new ArrayList<>();
            else {
                basket = (ArrayList<BasketItem>) session.getAttribute("basket");
                boolean uniqueItem = true;
                for (BasketItem basketItem : basket) {
                    if (basketItem.equals(newItem)) {
                        basketItem.add(newItem.getAmount());
                        uniqueItem = false;
                        break;
                    }
                }
                if (uniqueItem) basket.add(newItem);
            }
            session.setAttribute("basket", basket);
        }
        return pageToShow;
    }
}
